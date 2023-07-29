<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
          v-hasPermi="['sales:productList:add']"
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
          v-hasPermi="['sales:productList:edit']"
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
          v-hasPermi="['sales:productList:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['sales:productList:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="productListList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="销售报价产品ID" align="center" prop="quotationDetailId" />
      <el-table-column label="所属部门" align="center" prop="sysOrgCode" />
      <el-table-column label="产品名称" align="center" prop="prodctName" />
      <el-table-column label="型号" align="center" prop="model" />
      <el-table-column label="封装形式" align="center" prop="packageType" />
      <el-table-column label="类别" align="center" prop="category" />
      <el-table-column label="品牌" align="center" prop="brand" />
      <el-table-column label="单价" align="center" prop="unitPrice" />
      <el-table-column label="数量" align="center" prop="quantity" />
      <el-table-column label="金额" align="center" prop="amountMoney" />
      <el-table-column label="说明" align="center" prop="introduction" />
      <el-table-column label="销售报价Id" align="center" prop="quotationId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['sales:productList:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['sales:productList:remove']"
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

    <!-- 添加或修改销售报价产品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="所属部门" prop="sysOrgCode">
          <el-input v-model="form.sysOrgCode" placeholder="请输入所属部门" />
        </el-form-item>
        <el-form-item label="产品名称" prop="prodctName">
          <el-input v-model="form.prodctName" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="型号" prop="model">
          <el-input v-model="form.model" placeholder="请输入型号" />
        </el-form-item>
        <el-form-item label="类别" prop="category">
          <el-input v-model="form.category" placeholder="请输入类别" />
        </el-form-item>
        <el-form-item label="品牌" prop="brand">
          <el-input v-model="form.brand" placeholder="请输入品牌" />
        </el-form-item>
        <el-form-item label="单价" prop="unitPrice">
          <el-input v-model="form.unitPrice" placeholder="请输入单价" />
        </el-form-item>
        <el-form-item label="数量" prop="quantity">
          <el-input v-model="form.quantity" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="金额" prop="amountMoney">
          <el-input v-model="form.amountMoney" placeholder="请输入金额" />
        </el-form-item>
        <el-form-item label="说明" prop="introduction">
          <el-input v-model="form.introduction" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="销售报价Id" prop="quotationId">
          <el-input v-model="form.quotationId" placeholder="请输入销售报价Id" />
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
import { listProductList, getProductList, delProductList, addProductList, updateProductList } from "@/api/sales/productList";

export default {
  name: "ProductList",
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
      // 销售报价产品表格数据
      productListList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
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
    /** 查询销售报价产品列表 */
    getList() {
      this.loading = true;
      listProductList(this.queryParams).then(response => {
        this.productListList = response.rows;
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
        quotationDetailId: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        sysOrgCode: null,
        prodctName: null,
        model: null,
        packageType: null,
        category: null,
        brand: null,
        unitPrice: null,
        quantity: null,
        amountMoney: null,
        introduction: null,
        quotationId: null
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
      this.ids = selection.map(item => item.quotationDetailId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加销售报价产品";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const quotationDetailId = row.quotationDetailId || this.ids
      getProductList(quotationDetailId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改销售报价产品";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.quotationDetailId != null) {
            updateProductList(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProductList(this.form).then(response => {
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
      const quotationDetailIds = row.quotationDetailId || this.ids;
      this.$modal.confirm('是否确认删除销售报价产品编号为"' + quotationDetailIds + '"的数据项？').then(function() {
        return delProductList(quotationDetailIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('sales/productList/export', {
        ...this.queryParams
      }, `productList_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
