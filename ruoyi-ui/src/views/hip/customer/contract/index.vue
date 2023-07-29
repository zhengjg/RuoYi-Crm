<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="合同编号" prop="contractNo">
        <el-input
          v-model="queryParams.contractNo"
          placeholder="请输入合同编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="流程号" prop="flowId">
        <el-input
          v-model="queryParams.flowId"
          placeholder="请输入流程号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户名称" prop="customerName">
        <el-input
          v-model="queryParams.customerName"
          placeholder="请输入客户名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['customer:contract:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['customer:contract:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['customer:contract:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['customer:contract:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="contractList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="合同Id" align="center" prop="contractId"/>
      <el-table-column label="合同编号" align="center" prop="contractNo" />
      <el-table-column label="签署地点" align="center" prop="signAddress" />
      <el-table-column label="供方" align="center" prop="supplier" />
      <el-table-column label="客户Id" align="center" prop="customerId" />
      <el-table-column label="收货地址" align="center" prop="deliveryAddress" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="合同类型" align="center" prop="contractType" />
      <el-table-column label="付款方式" align="center" prop="settlementType" />
      <el-table-column label="税率" align="center" prop="taxRate" />
      <el-table-column label="合同总价" align="center" prop="totalPrice" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="流程号" align="center" prop="flowId" />
      <el-table-column label="当前节点" align="center" prop="currentNode" />
      <el-table-column label="客户名称" align="center" prop="customerName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['customer:contract:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['customer:contract:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改合同对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="合同编号" prop="contractNo">
          <el-input v-model="form.contractNo" placeholder="请输入合同编号" />
        </el-form-item>
        <el-form-item label="签署地点" prop="signAddress">
          <el-input v-model="form.signAddress" placeholder="请输入签署地点" />
        </el-form-item>
        <el-form-item label="客户Id" prop="customerId">
          <el-input v-model="form.customerId" placeholder="请输入客户Id" />
        </el-form-item>
        <el-form-item label="收货地址" prop="deliveryAddress">
          <el-input v-model="form.deliveryAddress" placeholder="请输入收货地址" />
        </el-form-item>
        <el-form-item label="税率" prop="taxRate">
          <el-input v-model="form.taxRate" placeholder="请输入税率" />
        </el-form-item>
        <el-form-item label="合同总价" prop="totalPrice">
          <el-input v-model="form.totalPrice" placeholder="请输入合同总价" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="流程号" prop="flowId">
          <el-input v-model="form.flowId" placeholder="请输入流程号" />
        </el-form-item>
        <el-form-item label="当前节点" prop="currentNode">
          <el-input v-model="form.currentNode" placeholder="请输入当前节点" />
        </el-form-item>
        <el-form-item label="客户名称" prop="customerName">
          <el-input v-model="form.customerName" placeholder="请输入客户名称" />
        </el-form-item>
        <el-divider content-position="center">产品信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddHipContractOrder">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteHipContractOrder">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="hipContractOrderList" :row-class-name="rowHipContractOrderIndex" @selection-change="handleHipContractOrderSelectionChange" ref="hipContractOrder">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="产品名称" prop="prodctName" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.prodctName" placeholder="请输入产品名称" />
            </template>
          </el-table-column>
          <el-table-column label="型号" prop="model" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.model" placeholder="请输入型号" />
            </template>
          </el-table-column>
          <el-table-column label="容量" prop="capacity" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.capacity" placeholder="请输入容量" />
            </template>
          </el-table-column>
          <el-table-column label="类别" prop="category" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.category" placeholder="请输入类别" />
            </template>
          </el-table-column>
          <el-table-column label="品牌" prop="brand" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.brand" placeholder="请输入品牌" />
            </template>
          </el-table-column>
          <el-table-column label="状态" prop="status" width="150">
            <template slot-scope="scope">
              <el-select v-model="scope.row.status" placeholder="请选择状态">
                <el-option label="请选择字典生成" value="" />
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="单价" prop="unitPrice" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.unitPrice" placeholder="请输入单价" />
            </template>
          </el-table-column>
          <el-table-column label="数量" prop="quantity" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.quantity" placeholder="请输入数量" />
            </template>
          </el-table-column>
          <el-table-column label="金额" prop="amountMoney" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.amountMoney" placeholder="请输入金额" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listContract, getContract, delContract, addContract, updateContract } from "@/api/customer/contract";

export default {
  name: "Contract",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedHipContractOrder: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 合同表格数据
      contractList: [],
      // 合同表格数据
      hipContractOrderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        contractNo: null,
        status: null,
        contractType: null,
        settlementType: null,
        flowId: null,
        customerName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询合同列表 */
    getList() {
      this.loading = true;
      listContract(this.queryParams).then(response => {
        this.contractList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        contractId: null,
        contractNo: null,
        signAddress: null,
        supplier: null,
        customerId: null,
        deliveryAddress: null,
        status: null,
        contractType: null,
        settlementType: null,
        taxRate: null,
        totalPrice: null,
        remark: null,
        flowId: null,
        currentNode: null,
        customerName: null,
        createTime: null,
        createBy: null,
        updateBy: null,
        updateTime: null
      };
      this.hipContractOrderList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.contractId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加合同";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const contractId = row.contractId || this.ids
      getContract(contractId).then(response => {
        this.form = response.data;
        this.hipContractOrderList = response.data.hipContractOrderList;
        this.open = true;
        this.title = "修改合同";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.hipContractOrderList = this.hipContractOrderList;
          if (this.form.contractId != null) {
            updateContract(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addContract(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const contractIds = row.contractId || this.ids;
      this.$modal.confirm('是否确认删除合同编号为"' + contractIds + '"的数据项？').then(function() {
        return delContract(contractIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 合同序号 */
    rowHipContractOrderIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 合同添加按钮操作 */
    handleAddHipContractOrder() {
      let obj = {};
      obj.prodctName = "";
      obj.model = "";
      obj.capacity = "";
      obj.category = "";
      obj.brand = "";
      obj.status = "";
      obj.unitPrice = "";
      obj.quantity = "";
      obj.amountMoney = "";
      obj.remarks = "";
      this.hipContractOrderList.push(obj);
    },
    /** 合同删除按钮操作 */
    handleDeleteHipContractOrder() {
      if (this.checkedHipContractOrder.length == 0) {
        this.$modal.msgError("请先选择要删除的合同数据");
      } else {
        const hipContractOrderList = this.hipContractOrderList;
        const checkedHipContractOrder = this.checkedHipContractOrder;
        this.hipContractOrderList = hipContractOrderList.filter(function(item) {
          return checkedHipContractOrder.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleHipContractOrderSelectionChange(selection) {
      this.checkedHipContractOrder = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('customer/contract/export', {
        ...this.queryParams
      }, `contract_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
