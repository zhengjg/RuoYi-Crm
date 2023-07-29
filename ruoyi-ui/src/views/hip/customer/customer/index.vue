<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户分类" prop="customerCategory">
        <el-select v-model="queryParams.customerCategory" placeholder="请选择客户分类" clearable>
          <el-option
            v-for="dict in dict.type.customer_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="客户等级" prop="customerLevel">
        <el-select v-model="queryParams.customerLevel" placeholder="请选择客户等级" clearable>
          <el-option
            v-for="dict in dict.type.customer_level"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="所属地区" prop="area">
        <el-input
          v-model="queryParams.area"
          placeholder="请输入所属地区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="业务员" prop="salesMan">
        <el-input
          v-model="queryParams.salesMan"
          placeholder="请输入业务员"
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
          v-hasPermi="['customer:customer:add']"
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
          v-hasPermi="['customer:customer:edit']"
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
          v-hasPermi="['customer:customer:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['customer:customer:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="customerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编码" align="center" prop="code" fixed="left"/>
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="简称" align="center" prop="shortName" />
      <el-table-column label="助记名" align="center" prop="auxName" />
      <el-table-column label="客户分类" align="center" prop="customerCategory">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.customer_type" :value="scope.row.customerCategory"/>
        </template>
      </el-table-column>
      <el-table-column label="客户等级" align="center" prop="customerLevel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.customer_level" :value="scope.row.customerLevel"/>
        </template>
      </el-table-column>
      <el-table-column label="纳税规模" align="center" prop="taxScale">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.tax_scope" :value="scope.row.taxScale"/>
        </template>
      </el-table-column>
      <el-table-column label="欠款额度" align="center" prop="creditQuota" />
      <el-table-column label="所属总公司" align="center" prop="headquarters" />
      <el-table-column label="所属地区" align="center" prop="area" />
      <el-table-column label="业务区域" align="center" prop="bizArea" />
      <el-table-column label="客户地址" align="center" prop="address" />
      <el-table-column label="客户网站" align="center" prop="website" />
      <el-table-column label="法人代表" align="center" prop="legalPerson" />
      <el-table-column label="法人电话" align="center" prop="legalPersonPhone" />
      <el-table-column label="财务联系人" align="center" prop="financialContacts" />
      <el-table-column label="财务电话" align="center" prop="financialPhone" />
      <el-table-column label="开票单位名称" align="center" prop="invoiceCompany" />
      <el-table-column label="开票税号" align="center" prop="invoiceTaxCode" />
      <el-table-column label="开票开户行" align="center" prop="invoiceBankName" />
      <el-table-column label="开票行号" align="center" prop="invoiceBankCode" />
      <el-table-column label="开票账号" align="center" prop="invoiceAccount" />
      <el-table-column label="开票电话" align="center" prop="invoicePhone" />
      <el-table-column label="开票地址" align="center" prop="invoiceAddress" />
      <el-table-column label="办款单位名称" align="center" prop="paymentCompany" />
      <el-table-column label="办款开户行" align="center" prop="paymentBankName" />
      <el-table-column label="办款行号" align="center" prop="paymentBankCode" />
      <el-table-column label="办款账号" align="center" prop="paymentAccount" />
      <el-table-column label="收件人" align="center" prop="recvName" />
      <el-table-column label="联系电话" align="center" prop="recvPhone" />
      <el-table-column label="传真" align="center" prop="recvFax" />
      <el-table-column label="Email" align="center" prop="recvEmail" />
      <el-table-column label="地址" align="center" prop="recvAddress" />
      <el-table-column label="邮编" align="center" prop="recvPostcode" />
      <el-table-column label="附件" align="center" prop="attachment" />
      <el-table-column label="启用" align="center" prop="isEnabled" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="版本" align="center" prop="version" />
      <el-table-column label="业务员" align="center" prop="salesMan" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['customer:customer:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['customer:customer:remove']"
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

    <!-- 添加或修改新建客户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1000px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="编码" prop="code">
          <el-input v-model="form.code" placeholder="请输入编码" />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="简称" prop="shortName">
          <el-input v-model="form.shortName" placeholder="请输入简称" />
        </el-form-item>
        <el-form-item label="助记名" prop="auxName">
          <el-input v-model="form.auxName" placeholder="请输入助记名" />
        </el-form-item>
        <el-form-item label="客户分类" prop="customerCategory">
          <el-select v-model="form.customerCategory" placeholder="请选择客户分类">
            <el-option
              v-for="dict in dict.type.customer_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户等级" prop="customerLevel">
          <el-select v-model="form.customerLevel" placeholder="请选择客户等级">
            <el-option
              v-for="dict in dict.type.customer_level"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="纳税规模" prop="taxScale">
          <el-select v-model="form.taxScale" placeholder="请选择纳税规模">
            <el-option
              v-for="dict in dict.type.tax_scope"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="欠款额度" prop="creditQuota">
          <el-input v-model="form.creditQuota" placeholder="请输入欠款额度" />
        </el-form-item>
        <el-form-item label="所属总公司" prop="headquarters">
          <el-input v-model="form.headquarters" placeholder="请输入所属总公司" />
        </el-form-item>
        <el-form-item label="所属地区" prop="area">
          <el-input v-model="form.area" placeholder="请输入所属地区" />
        </el-form-item>
        <el-form-item label="业务区域" prop="bizArea">
          <el-input v-model="form.bizArea" placeholder="请输入业务区域" />
        </el-form-item>
        <el-form-item label="客户地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入客户地址" />
        </el-form-item>
        <el-form-item label="客户网站" prop="website">
          <el-input v-model="form.website" placeholder="请输入客户网站" />
        </el-form-item>
        <el-form-item label="法人代表" prop="legalPerson">
          <el-input v-model="form.legalPerson" placeholder="请输入法人代表" />
        </el-form-item>
        <el-form-item label="法人电话" prop="legalPersonPhone">
          <el-input v-model="form.legalPersonPhone" placeholder="请输入法人电话" />
        </el-form-item>
        <el-form-item label="财务联系人" prop="financialContacts">
          <el-input v-model="form.financialContacts" placeholder="请输入财务信息联系人" />
        </el-form-item>
        <el-form-item label="财务联系电话" prop="financialPhone">
          <el-input v-model="form.financialPhone" placeholder="请输入财务信息联系电话" />
        </el-form-item>
        <el-form-item label="开票单位名称" prop="invoiceCompany">
          <el-input v-model="form.invoiceCompany" placeholder="请输入开票信息单位名称" />
        </el-form-item>
        <el-form-item label="开票税号" prop="invoiceTaxCode">
          <el-input v-model="form.invoiceTaxCode" placeholder="请输入开票信息税号" />
        </el-form-item>
        <el-form-item label="开票开户行" prop="invoiceBankName">
          <el-input v-model="form.invoiceBankName" placeholder="请输入开票信息开户行" />
        </el-form-item>
        <el-form-item label="开票行号" prop="invoiceBankCode">
          <el-input v-model="form.invoiceBankCode" placeholder="请输入开票信息行号" />
        </el-form-item>
        <el-form-item label="开票账号" prop="invoiceAccount">
          <el-input v-model="form.invoiceAccount" placeholder="请输入开票信息账号" />
        </el-form-item>
        <el-form-item label="开票电话" prop="invoicePhone">
          <el-input v-model="form.invoicePhone" placeholder="请输入开票信息联系电话" />
        </el-form-item>
        <el-form-item label="开票地址" prop="invoiceAddress">
          <el-input v-model="form.invoiceAddress" placeholder="请输入开票地址" />
        </el-form-item>
        <el-form-item label="单位名称" prop="paymentCompany">
          <el-input v-model="form.paymentCompany" placeholder="请输入办款资料单位名称" />
        </el-form-item>
        <el-form-item label="开户行" prop="paymentBankName">
          <el-input v-model="form.paymentBankName" placeholder="请输入办款资料开户行" />
        </el-form-item>
        <el-form-item label="行号" prop="paymentBankCode">
          <el-input v-model="form.paymentBankCode" placeholder="请输入办款资料行号" />
        </el-form-item>
        <el-form-item label="账号" prop="paymentAccount">
          <el-input v-model="form.paymentAccount" placeholder="请输入办款资料账号" />
        </el-form-item>
        <el-form-item label="收件人" prop="recvName">
          <el-input v-model="form.recvName" placeholder="请输入收件信息收件人" />
        </el-form-item>
        <el-form-item label="联系电话" prop="recvPhone">
          <el-input v-model="form.recvPhone" placeholder="请输入收件信息联系电话" />
        </el-form-item>
        <el-form-item label="传真" prop="recvFax">
          <el-input v-model="form.recvFax" placeholder="请输入收件信息传真" />
        </el-form-item>
        <el-form-item label="Email" prop="recvEmail">
          <el-input v-model="form.recvEmail" placeholder="请输入收件信息Email" />
        </el-form-item>
        <el-form-item label="地址" prop="recvAddress">
          <el-input v-model="form.recvAddress" placeholder="请输入收件信息地址" />
        </el-form-item>
        <el-form-item label="邮编" prop="recvPostcode">
          <el-input v-model="form.recvPostcode" placeholder="请输入收件信息邮编" />
        </el-form-item>
        <el-form-item label="附件" prop="attachment">
          <el-input v-model="form.attachment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="启用" prop="isEnabled">
          <el-input v-model="form.isEnabled" placeholder="请输入启用" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="版本" prop="version">
          <el-input v-model="form.version" placeholder="请输入版本" />
        </el-form-item>
        <el-form-item label="业务员" prop="salesMan">
          <el-input v-model="form.salesMan" placeholder="请输入业务员" />
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
import { listCustomer, getCustomer, delCustomer, addCustomer, updateCustomer } from "@/api/customer/customer";

export default {
  name: "Customer",
  dicts: ['tax_scope', 'customer_type', 'customer_level'],
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
      // 新建客户表格数据
      customerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        customerCategory: null,
        customerLevel: null,
        area: null,
        salesMan: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        code: [
          { required: true, message: "编码不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "名称不能为空", trigger: "blur" }
        ],
        auxName: [
          { required: true, message: "助记名不能为空", trigger: "blur" }
        ],
        isEnabled: [
          { required: true, message: "启用不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询新建客户列表 */
    getList() {
      this.loading = true;
      listCustomer(this.queryParams).then(response => {
        this.customerList = response.rows;
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
        customerId: null,
        code: null,
        name: null,
        shortName: null,
        auxName: null,
        customerCategory: null,
        customerLevel: null,
        taxScale: null,
        creditQuota: null,
        headquarters: null,
        area: null,
        bizArea: null,
        address: null,
        website: null,
        legalPerson: null,
        legalPersonPhone: null,
        financialContacts: null,
        financialPhone: null,
        invoiceCompany: null,
        invoiceTaxCode: null,
        invoiceBankName: null,
        invoiceBankCode: null,
        invoiceAccount: null,
        invoicePhone: null,
        invoiceAddress: null,
        paymentCompany: null,
        paymentBankName: null,
        paymentBankCode: null,
        paymentAccount: null,
        recvName: null,
        recvPhone: null,
        recvFax: null,
        recvEmail: null,
        recvAddress: null,
        recvPostcode: null,
        attachment: null,
        isEnabled: null,
        remark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        version: null,
        salesMan: null
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
      this.ids = selection.map(item => item.customerId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加客户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const customerId = row.customerId || this.ids
      getCustomer(customerId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改客户";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.customerId != null) {
            updateCustomer(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCustomer(this.form).then(response => {
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
      const customerIds = row.customerId || this.ids;
      this.$modal.confirm('是否确认删除新建客户编号为"' + customerIds + '"的数据项？').then(function() {
        return delCustomer(customerIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('customer/customer/export', {
        ...this.queryParams
      }, `customer_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
