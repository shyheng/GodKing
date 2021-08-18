<template>
  <div>

    <template v-if="workList.length">
      <el-table
        :data="workList"
        border
        style="width: 100%">
        <el-table-column
          prop="date"
          label=""
          width="180">
        </el-table-column>
        <el-table-column
          prop="monday"
          label="星期一"
          width="180">
        </el-table-column>
        <el-table-column
          prop="tuesday"
          label="星期二">
        </el-table-column>
        <el-table-column
          prop="wednesday"
          label="星期三">
        </el-table-column>
        <el-table-column
          prop="thursday"
          label="星期四">
        </el-table-column>
        <el-table-column
          prop="friday"
          label="星期五">
        </el-table-column>
        <el-table-column
          prop="saturday"
          label="星期六">
        </el-table-column>
        <el-table-column
          prop="sunday"
          label="星期七">
        </el-table-column>
      </el-table>
      <el-button type="primary" @click="dialogFormVisible = true">打开嵌套表单的 Dialog</el-button>

      <el-dialog title="更改信息" width="100%" :visible.sync="dialogFormVisible">
        <div>
          <table>
            <tr>
              <td>
                <input type="text"/>
              </td>
              <td>
                <input type="text"/>
              </td>
              <td>
                <input type="text"/>
              </td>
              <td>
                <input type="text"/>
              </td>
              <td>
                <input type="text"/>
              </td>
              <td>
                <input type="text"/>
              </td>
              <td>
                <input type="text"/>
              </td>
            </tr>
          </table>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
        </div>
      </el-dialog>
    </template>
    <el-button type="primary" v-else @click="work">获取作息</el-button>
  </div>
</template>

<script>
export default {

  data () {
    return {
      workList: [],
      dialogFormVisible: false,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    async work () {
      const { data: res } = await this.$http.get('work', { params: this.shy })
      this.workList = res.work
    },
    async up_work(){

    }
  }
}

</script>

<style scoped>

</style>
