<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="入库单据编号" prop="billNo">
        <el-input
          v-model="queryParams.billNo"
          placeholder="请输入入库单据编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库时间" prop="whsInDate">
        <el-date-picker clearable
          v-model="queryParams.whsInDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择入库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="经办人" prop="handleBy">
        <el-input
          v-model="queryParams.handleBy"
          placeholder="请输入经办人"
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
          v-hasPermi="['stock:inDetail:add']"
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
          v-hasPermi="['stock:inDetail:edit']"
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
          v-hasPermi="['stock:inDetail:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['stock:inDetail:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="inDetailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="出库明细ID" align="center" prop="stockInDetailId" />
      <el-table-column label="入库单据编号" align="center" prop="billNo" />
      <el-table-column label="入库时间" align="center" prop="whsInDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.whsInDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="经办人" align="center" prop="handleBy" />
      <el-table-column label="数量" align="center" prop="amounts" />
      <el-table-column label="金额" align="center" prop="price" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['stock:inDetail:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['stock:inDetail:remove']"
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

    <!-- 添加或修改入库明细对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="入库单据编号" prop="billNo">
          <el-input v-model="form.billNo" placeholder="请输入入库单据编号" />
        </el-form-item>
        <el-form-item label="入库时间" prop="whsInDate">
          <el-date-picker clearable
            v-model="form.whsInDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="经办人" prop="handleBy">
          <el-input v-model="form.handleBy" placeholder="请输入经办人" />
        </el-form-item>
        <el-form-item label="数量" prop="amounts">
          <el-input v-model="form.amounts" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="金额" prop="price">
          <el-input v-model="form.price" placeholder="请输入金额" />
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
import { listInDetail, getInDetail, delInDetail, addInDetail, updateInDetail } from "@/api/stock/inDetail";

export default {
  name: "InDetail",
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
      // 入库明细表格数据
      inDetailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        billNo: null,
        whsInDate: null,
        handleBy: null,
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
    /** 查询入库明细列表 */
    getList() {
      this.loading = true;
      listInDetail(this.queryParams).then(response => {
        this.inDetailList = response.rows;
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
        stockInDetailId: null,
        billNo: null,
        whsInDate: null,
        handleBy: null,
        amounts: null,
        price: null
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
      this.ids = selection.map(item => item.stockInDetailId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加入库明细";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const stockInDetailId = row.stockInDetailId || this.ids
      getInDetail(stockInDetailId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改入库明细";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.stockInDetailId != null) {
            updateInDetail(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInDetail(this.form).then(response => {
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
      const stockInDetailIds = row.stockInDetailId || this.ids;
      this.$modal.confirm('是否确认删除入库明细编号为"' + stockInDetailIds + '"的数据项？').then(function() {
        return delInDetail(stockInDetailIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('stock/inDetail/export', {
        ...this.queryParams
      }, `inDetail_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
