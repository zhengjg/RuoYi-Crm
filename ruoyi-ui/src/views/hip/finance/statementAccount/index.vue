<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="辅助发货日期" prop="extDeliveryDate">
        <el-date-picker clearable
          v-model="queryParams.extDeliveryDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择辅助发货日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="辅助收款日期" prop="extPaymentDate">
        <el-date-picker clearable
          v-model="queryParams.extPaymentDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择辅助收款日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="处理日期" prop="handleDate">
        <el-date-picker clearable
          v-model="queryParams.handleDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择处理日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="是否含税" prop="isTax">
        <el-input
          v-model="queryParams.isTax"
          placeholder="请输入是否含税"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否开票" prop="isInvoicing">
        <el-input
          v-model="queryParams.isInvoicing"
          placeholder="请输入是否开票"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="处理开票日期" prop="invoicingDate">
        <el-date-picker clearable
          v-model="queryParams.invoicingDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择处理开票日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="销售单号" prop="saleNo">
        <el-input
          v-model="queryParams.saleNo"
          placeholder="请输入销售单号"
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
          v-hasPermi="['finance:statementAccount:add']"
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
          v-hasPermi="['finance:statementAccount:edit']"
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
          v-hasPermi="['finance:statementAccount:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['finance:statementAccount:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="statementAccountList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="销售ID" align="center" prop="salesId" />
      <el-table-column label="所属部门" align="center" prop="sysOrgCode" />
      <el-table-column label="辅助发货日期" align="center" prop="extDeliveryDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.extDeliveryDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="辅助收款日期" align="center" prop="extPaymentDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.extPaymentDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同编号" align="center" prop="contractNum" />
      <el-table-column label="处理日期" align="center" prop="handleDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.handleDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="交货地址" align="center" prop="deliveryAddress" />
      <el-table-column label="品牌" align="center" prop="brand" />
      <el-table-column label="容量" align="center" prop="capactiy" />
      <el-table-column label="数量" align="center" prop="num" />
      <el-table-column label="是否含税" align="center" prop="isTax" />
      <el-table-column label="单价" align="center" prop="price" />
      <el-table-column label="应收账款" align="center" prop="receivable" />
      <el-table-column label="已收账款" align="center" prop="received" />
      <el-table-column label="收款日期" align="center" prop="receivedDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.receivedDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="收款金额" align="center" prop="receivedMoney" />
      <el-table-column label="应收帐款余额" align="center" prop="receivableRemainder" />
      <el-table-column label="是否开票" align="center" prop="isInvoicing" />
      <el-table-column label="处理开票日期" align="center" prop="invoicingDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.invoicingDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="已开票金额" align="center" prop="invoicedMoney" />
      <el-table-column label="应开票金额" align="center" prop="invoicingMoney" />
      <el-table-column label="未开票金额" align="center" prop="uninvoicedMoney" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="销售单号" align="center" prop="saleNo" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['finance:statementAccount:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['finance:statementAccount:remove']"
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

    <!-- 添加或修改对账单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="所属部门" prop="sysOrgCode">
          <el-input v-model="form.sysOrgCode" placeholder="请输入所属部门" />
        </el-form-item>
        <el-form-item label="辅助发货日期" prop="extDeliveryDate">
          <el-date-picker clearable
            v-model="form.extDeliveryDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择辅助发货日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="辅助收款日期" prop="extPaymentDate">
          <el-date-picker clearable
            v-model="form.extPaymentDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择辅助收款日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="合同编号" prop="contractNum">
          <el-input v-model="form.contractNum" placeholder="请输入合同编号" />
        </el-form-item>
        <el-form-item label="处理日期" prop="handleDate">
          <el-date-picker clearable
            v-model="form.handleDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择处理日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="交货地址" prop="deliveryAddress">
          <el-input v-model="form.deliveryAddress" placeholder="请输入交货地址" />
        </el-form-item>
        <el-form-item label="品牌" prop="brand">
          <el-input v-model="form.brand" placeholder="请输入品牌" />
        </el-form-item>
        <el-form-item label="容量" prop="capactiy">
          <el-input v-model="form.capactiy" placeholder="请输入容量" />
        </el-form-item>
        <el-form-item label="数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="是否含税" prop="isTax">
          <el-input v-model="form.isTax" placeholder="请输入是否含税" />
        </el-form-item>
        <el-form-item label="单价" prop="price">
          <el-input v-model="form.price" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="应收账款" prop="receivable">
          <el-input v-model="form.receivable" placeholder="请输入应收账款" />
        </el-form-item>
        <el-form-item label="已收账款" prop="received">
          <el-input v-model="form.received" placeholder="请输入已收账款" />
        </el-form-item>
        <el-form-item label="收款日期" prop="receivedDate">
          <el-date-picker clearable
            v-model="form.receivedDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择收款日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="收款金额" prop="receivedMoney">
          <el-input v-model="form.receivedMoney" placeholder="请输入收款金额" />
        </el-form-item>
        <el-form-item label="应收帐款余额" prop="receivableRemainder">
          <el-input v-model="form.receivableRemainder" placeholder="请输入应收帐款余额" />
        </el-form-item>
        <el-form-item label="是否开票" prop="isInvoicing">
          <el-input v-model="form.isInvoicing" placeholder="请输入是否开票" />
        </el-form-item>
        <el-form-item label="处理开票日期" prop="invoicingDate">
          <el-date-picker clearable
            v-model="form.invoicingDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择处理开票日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="已开票金额" prop="invoicedMoney">
          <el-input v-model="form.invoicedMoney" placeholder="请输入已开票金额" />
        </el-form-item>
        <el-form-item label="应开票金额" prop="invoicingMoney">
          <el-input v-model="form.invoicingMoney" placeholder="请输入应开票金额" />
        </el-form-item>
        <el-form-item label="未开票金额" prop="uninvoicedMoney">
          <el-input v-model="form.uninvoicedMoney" placeholder="请输入未开票金额" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="销售单号" prop="saleNo">
          <el-input v-model="form.saleNo" placeholder="请输入销售单号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStatementAccount, getStatementAccount, delStatementAccount, addStatementAccount, updateStatementAccount } from "@/api/finance/statementAccount";

export default {
  name: "StatementAccount",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 对账单表格数据
      statementAccountList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        extDeliveryDate: null,
        extPaymentDate: null,
        handleDate: null,
        isTax: null,
        isInvoicing: null,
        invoicingDate: null,
        saleNo: null
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
    /** 查询对账单列表 */
    getList() {
      this.loading = true;
      listStatementAccount(this.queryParams).then(response => {
        this.statementAccountList = response.rows;
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
        salesId: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        sysOrgCode: null,
        extDeliveryDate: null,
        extPaymentDate: null,
        contractNum: null,
        handleDate: null,
        deliveryAddress: null,
        brand: null,
        capactiy: null,
        num: null,
        isTax: null,
        price: null,
        receivable: null,
        received: null,
        receivedDate: null,
        receivedMoney: null,
        receivableRemainder: null,
        isInvoicing: null,
        invoicingDate: null,
        invoicedMoney: null,
        invoicingMoney: null,
        uninvoicedMoney: null,
        remarks: null,
        saleNo: null
      };
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
      this.ids = selection.map(item => item.salesId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加对账单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const salesId = row.salesId || this.ids
      getStatementAccount(salesId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改对账单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.salesId != null) {
            updateStatementAccount(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStatementAccount(this.form).then(response => {
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
      const salesIds = row.salesId || this.ids;
      this.$modal.confirm('是否确认删除对账单编号为"' + salesIds + '"的数据项？').then(function() {
        return delStatementAccount(salesIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('finance/statementAccount/export', {
        ...this.queryParams
      }, `statementAccount_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
