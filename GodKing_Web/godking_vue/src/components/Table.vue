<template>
  <div>

    <template v-if="workList.length">
      <div class="table-wrapper">
        <el-table
          :data="workList"
          border
          style="width: 100%;color: greenyellow;"
          >
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
      </div>
      <el-button type="primary" @click="dialogFormVisible = true">更改内容</el-button>

      <el-dialog title="更改信息" width="80%" :visible.sync="dialogFormVisible">

        <div>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          星期一
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          星期二
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          星期三
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          星期四
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          星期五
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          星期六
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          星期天
          <table v-for="works in workList">
            {{works.date}}
            <br>
            <tr >

              <td>

                <input v-model="works.monday" type="text"/>
              </td>
              <td>

                <input v-model="works.tuesday" type="text"/>
              </td>
              <td>
                <input v-model="works.wednesday" type="text"/>
              </td>
              <td>
                <input v-model="works.thursday" type="text"/>
              </td>
              <td>
                <input v-model="works.friday" type="text"/>
              </td>
              <td>

                <input v-model="works.saturday" type="text"/>
              </td>
              <td>
                <input v-model="works.sunday" type="text"/>
              </td>
            </tr>
          </table>
        </div>

        <el-button @click="up_work">提交</el-button>

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
      formLabelWidth: '120px'
    }
  },
  methods: {
    async work () {
      const { data: res } = await this.$http.get('work', { params: this.shy })
      this.workList = res.work
    },
    async up_work () {

      for (let i = 0; i < this.workList.length; i++) {
        let work = this.workList[i]
        const { data: res } = await this.$http.get('up_work', { params: work })
      }
      location.reload()
    },
  },
  mounted () {
    this.work()
  }
}

</script>

<style scoped>
.table-wrapper /deep/ .el-table--fit{
  padding: 20px;
}
.table-wrapper /deep/  .el-table, .el-table__expanded-cell {
  background-color: transparent;
}

.table-wrapper /deep/ .el-table tr {
  background-color: transparent!important;
}
.table-wrapper /deep/  .el-table--enable-row-transition .el-table__body td, .el-table .cell{
  background-color: transparent;
}
</style>
