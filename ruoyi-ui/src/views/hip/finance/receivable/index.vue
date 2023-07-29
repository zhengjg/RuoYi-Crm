<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="收款日期" prop="receiptDate">
        <el-date-picker clearable
          v-model="queryParams.receiptDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择收款日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="是否开票" prop="isInvoice">
        <el-input
          v-model="queryParams.isInvoice"
          placeholder="请输入是否开票"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开票日期" prop="invoiceDate">
        <el-date-picker clearable
          v-model="queryParams.invoiceDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开票日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="经办人" prop="handledBy">
        <el-input
          v-model="queryParams.handledBy"
          placeholder="请输入经办人"
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
          v-hasPermi="['finance:receivable:add']"
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
          v-hasPermi="['finance:receivable:edit']"
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
          v-hasPermi="['finance:receivable:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['finance:receivable:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="receivableList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="账单ID" align="center" prop="billId" />
      <el-table-column label="所属部门" align="center" prop="sysOrgCode" />
      <el-table-column label="应收" align="center" prop="receivable" />
      <el-table-column label="已收" align="center" prop="received" />
      <el-table-column label="结余" align="center" prop="remainder" />
      <el-table-column label="税点" align="center" prop="taxPoint" />
      <el-table-column label="收款日期" align="center" prop="receiptDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.receiptDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="是否开票" align="center" prop="isInvoice">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.is_invoicing" :value="scope.row.isInvoice"/>
        </template>
      </el-table-column>
      <el-table-column label="开票日期" align="center" prop="invoiceDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.invoiceDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="应开票金额" align="center" prop="invoiceAmount" />
      <el-table-column label="已开票金额" align="center" prop="invoicedAmount" />
      <el-table-column label="未开票金额" align="center" prop="uninvoicedAmount" />
      <el-table-column label="冲红" align="center" prop="invoiceReversal" />
      <el-table-column label="经办人" align="center" prop="handledBy" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="合同编号" align="center" prop="contractNo" />
      <el-table-column label="是否结清" align="center" prop="isEnding" />
      <el-table-column label="客户名称" align="center" prop="customerName" />
      <el-table-column label="客户Id" align="center" prop="customerId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['finance:receivable:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['finance:receivable:remove']"
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

    <!-- 添加或修改finance对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="所属部门" prop="sysOrgCode">
          <el-input v-model="form.sysOrgCode" placeholder="请输入所属部门" />
        </el-form-item>
        <el-form-item label="应收" prop="receivable">
          <el-input v-model="form.receivable" placeholder="请输入应收" />
        </el-form-item>
        <el-form-item label="已收" prop="received">
          <el-input v-model="form.received" placeholder="请输入已收" />
        </el-form-item>
        <el-form-item label="结余" prop="remainder">
          <el-input v-model="form.remainder" placeholder="请输入结余" />
        </el-form-item>
        <el-form-item label="税点" prop="taxPoint">
          <el-input v-model="form.taxPoint" placeholder="请输入税点" />
        </el-form-item>
        <el-form-item label="收款日期" prop="receiptDate">
          <el-date-picker clearable
            v-model="form.receiptDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择收款日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否开票" prop="isInvoice">
          <el-input v-model="form.isInvoice" placeholder="请输入是否开票" />
        </el-form-item>
        <el-form-item label="开票日期" prop="invoiceDate">
          <el-date-picker clearable
            v-model="form.invoiceDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开票日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="应开票金额" prop="invoiceAmount">
          <el-input v-model="form.invoiceAmount" placeholder="请输入应开票金额" />
        </el-form-item>
        <el-form-item label="已开票金额" prop="invoicedAmount">
          <el-input v-model="form.invoicedAmount" placeholder="请输入已开票金额" />
        </el-form-item>
        <el-form-item label="未开票金额" prop="uninvoicedAmount">
          <el-input v-model="form.uninvoicedAmount" placeholder="请输入未开票金额" />
        </el-form-item>
        <el-form-item label="冲红" prop="invoiceReversal">
          <el-input v-model="form.invoiceReversal" placeholder="请输入冲红" />
        </el-form-item>
        <el-form-item label="经办人" prop="handledBy">
          <el-input v-model="form.handledBy" placeholder="请输入经办人" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="合同编号" prop="contractNo">
          <el-input v-model="form.contractNo" placeholder="请输入合同编号" />
        </el-form-item>
        <el-form-item label="是否结清" prop="isEnding">
          <el-input v-model="form.isEnding" placeholder="请输入是否结清" />
        </el-form-item>
        <el-form-item label="客户名称" prop="customerName">
          <el-input v-model="form.customerName" placeholder="请输入客户名称" />
        </el-form-item>
        <el-form-item label="客户Id" prop="customerId">
          <el-input v-model="form.customerId" placeholder="请输入客户Id" />
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
import { listReceivable, getReceivable, delReceivable, addReceivable, updateReceivable } from "@/api/finance/receivable";

export default {
  name: "Receivable",
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
      // finance表格数据
      receivableList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        receiptDate: null,
        isInvoice: null,
        invoiceDate: null,
        handledBy: null,
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
    /** 查询finance列表 */
    getList() {
      this.loading = true;
      listReceivable(this.queryParams).then(response => {
        this.receivableList = response.rows;
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
        billId: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        sysOrgCode: null,
        receivable: null,
        received: null,
        remainder: null,
        taxPoint: null,
        receiptDate: null,
        isInvoice: null,
        invoiceDate: null,
        invoiceAmount: null,
        invoicedAmount: null,
        uninvoicedAmount: null,
        invoiceReversal: null,
        handledBy: null,
        remarks: null,
        contractNo: null,
        isEnding: null,
        customerName: null,
        customerId: null
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
      this.ids = selection.map(item => item.billId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const billId = row.billId || this.ids
      getReceivable(billId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.billId != null) {
            updateReceivable(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReceivable(this.form).then(response => {
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
      const billIds = row.billId || this.ids;
      this.$modal.confirm('是否确认删除finance编号为"' + billIds + '"的数据项？').then(function() {
        return delReceivable(billIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('finance/receivable/export', {
        ...this.queryParams
      }, `receivable_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
