<template>
  <div>
    <template v-if="notesList.length">
      <el-table
        :data="notesList"
        border
        style="width: 100%">
        <el-table-column
          prop="title"
          label="主题"
          width="180">
        </el-table-column>
        <el-table-column
          prop="data"
          label="时间"
          width="180">
        </el-table-column>

        <el-table-column
          prop="content"
          label="内容">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="120">
          <template slot-scope="scope">
            <el-button @click="deleteRow(scope.row.id)" type="text" size="small">
              移除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button type="primary" @click="dialogFormVisible = true">新增</el-button>

      <el-dialog title="新增日志" width="70%" :visible.sync="dialogFormVisible">

        <div>
          <el-form :model="notes">
            <el-form-item label="标题" :label-width="formLabelWidth">
              <el-input v-model="notes.title" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="内容" :label-width="formLabelWidth">
              <el-input
                type="textarea"
                :rows="2"
                placeholder="请输入内容"
                v-model="notes.content"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <el-button @click="add_notes">提交</el-button>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
        </div>
      </el-dialog>
    </template>
    <el-button type="primary" v-else @click="On_notes">获取作息</el-button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      dialogFormVisible: false,
      notesList: [],
      notes: {
        id:0,
        title: '',
        content: ''
      },

      formLabelWidth: '120px'
    }
  },
  methods: {
    async On_notes () {
      const { data: res } = await this.$http.get('notes', { params: this.shy })
      this.notesList = res.notes
    },
    async add_notes () {
      const { data: res } = await this.$http.get('add_notes', { params: this.notes })
      location.reload()
    },
    async deleteRow (id) {
      this.notes.id = id
      const {
        data: res
      } = await this.$http.get('del_notes', {
        params: this.notes
      })
      location.reload()
    }
  }
}
</script>

<style scoped>

</style>
