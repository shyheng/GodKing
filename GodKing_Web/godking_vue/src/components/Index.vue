<template>
  <div>
    {{shy}}
    <el-button @click="eat"></el-button>
  </div>
</template>

<script>

export default {
  data () {
    return {
      shy: 'shy'
    }
  },
  methods: {
    async eat () {
      const { data: res } = await this.$http.get('shy', { params: this.shy })
      // eslint-disable-next-line eqeqeq
      if (res.flag == 'err') return this.$message.error(res.msg)
      this.shy = res.shy
    }
  }
}
</script>

<style scoped>

</style>
