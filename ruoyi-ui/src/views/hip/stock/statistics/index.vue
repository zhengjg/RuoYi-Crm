<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="年" prop="year">
        <el-date-picker clearable
          v-model="queryParams.year"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择年">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="月" prop="month">
        <el-input
          v-model="queryParams.month"
          placeholder="请输入月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="仓库" prop="warehouse">
        <el-input
          v-model="queryParams.warehouse"
          placeholder="请输入仓库"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库数量" prop="stockInNum">
        <el-input
          v-model="queryParams.stockInNum"
          placeholder="请输入入库数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出库数量" prop="stockOutNum">
        <el-input
          v-model="queryParams.stockOutNum"
          placeholder="请输入出库数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库存数量" prop="stockAmount">
        <el-input
          v-model="queryParams.stockAmount"
          placeholder="请输入库存数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库金额" prop="stockInPrice">
        <el-input
          v-model="queryParams.stockInPrice"
          placeholder="请输入入库金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出库金额" prop="stockOutPrice">
        <el-input
          v-model="queryParams.stockOutPrice"
          placeholder="请输入出库金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结余金额" prop="stockPrice">
        <el-input
          v-model="queryParams.stockPrice"
          placeholder="请输入结余金额"
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
          v-hasPermi="['stock:statistics:add']"
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
          v-hasPermi="['stock:statistics:edit']"
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
          v-hasPermi="['stock:statistics:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['stock:statistics:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="statisticsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="出入库ID" align="center" prop="ioStatisticsId" />
      <el-table-column label="年" align="center" prop="year" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.year, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="月" align="center" prop="month" />
      <el-table-column label="仓库" align="center" prop="warehouse" />
      <el-table-column label="入库数量" align="center" prop="stockInNum" />
      <el-table-column label="出库数量" align="center" prop="stockOutNum" />
      <el-table-column label="库存数量" align="center" prop="stockAmount" />
      <el-table-column label="入库金额" align="center" prop="stockInPrice" />
      <el-table-column label="出库金额" align="center" prop="stockOutPrice" />
      <el-table-column label="结余金额" align="center" prop="stockPrice" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['stock:statistics:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['stock:statistics:remove']"
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

    <!-- 添加或修改出入库汇总对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="年" prop="year">
          <el-date-picker clearable
            v-model="form.year"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择年">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="月" prop="month">
          <el-input v-model="form.month" placeholder="请输入月" />
        </el-form-item>
        <el-form-item label="仓库" prop="warehouse">
          <el-input v-model="form.warehouse" placeholder="请输入仓库" />
        </el-form-item>
        <el-form-item label="入库数量" prop="stockInNum">
          <el-input v-model="form.stockInNum" placeholder="请输入入库数量" />
        </el-form-item>
        <el-form-item label="出库数量" prop="stockOutNum">
          <el-input v-model="form.stockOutNum" placeholder="请输入出库数量" />
        </el-form-item>
        <el-form-item label="库存数量" prop="stockAmount">
          <el-input v-model="form.stockAmount" placeholder="请输入库存数量" />
        </el-form-item>
        <el-form-item label="入库金额" prop="stockInPrice">
          <el-input v-model="form.stockInPrice" placeholder="请输入入库金额" />
        </el-form-item>
        <el-form-item label="出库金额" prop="stockOutPrice">
          <el-input v-model="form.stockOutPrice" placeholder="请输入出库金额" />
        </el-form-item>
        <el-form-item label="结余金额" prop="stockPrice">
          <el-input v-model="form.stockPrice" placeholder="请输入结余金额" />
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
import { listStatistics, getStatistics, delStatistics, addStatistics, updateStatistics } from "@/api/stock/statistics";

export default {
  name: "Statistics",
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
      // 出入库汇总表格数据
      statisticsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        year: null,
        month: null,
        warehouse: null,
        stockInNum: null,
        stockOutNum: null,
        stockAmount: null,
        stockInPrice: null,
        stockOutPrice: null,
        stockPrice: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        year: [
          { required: true, message: "年不能为空", trigger: "blur" }
        ],
        month: [
          { required: true, message: "月不能为空", trigger: "blur" }
        ],
        warehouse: [
          { required: true, message: "仓库不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询出入库汇总列表 */
    getList() {
      this.loading = true;
      listStatistics(this.queryParams).then(response => {
        this.statisticsList = response.rows;
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
        ioStatisticsId: null,
        year: null,
        month: null,
        warehouse: null,
        stockInNum: null,
        stockOutNum: null,
        stockAmount: null,
        stockInPrice: null,
        stockOutPrice: null,
        stockPrice: null
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
      this.ids = selection.map(item => item.ioStatisticsId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加出入库汇总";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ioStatisticsId = row.ioStatisticsId || this.ids
      getStatistics(ioStatisticsId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改出入库汇总";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.ioStatisticsId != null) {
            updateStatistics(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStatistics(this.form).then(response => {
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
      const ioStatisticsIds = row.ioStatisticsId || this.ids;
      this.$modal.confirm('是否确认删除出入库汇总编号为"' + ioStatisticsIds + '"的数据项？').then(function() {
        return delStatistics(ioStatisticsIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('stock/statistics/export', {
        ...this.queryParams
      }, `statistics_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
