<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="userid">
      <el-input v-model="dataForm.userid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="adminsid">
      <el-input v-model="dataForm.adminsid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="petid">
      <el-input v-model="dataForm.petid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="commenttime">
      <el-input v-model="dataForm.commenttime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="评论的内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="评论的内容"></el-input>
    </el-form-item>
    <el-form-item label="" prop="state">
      <el-input v-model="dataForm.state" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          userid: '',
          adminsid: '',
          petid: '',
          commenttime: '',
          content: '',
          state: ''
        },
        dataRule: {
          userid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          adminsid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          petid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          commenttime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '评论的内容不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/cat/help/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userid = data.help.userid
                this.dataForm.adminsid = data.help.adminsid
                this.dataForm.petid = data.help.petid
                this.dataForm.commenttime = data.help.commenttime
                this.dataForm.content = data.help.content
                this.dataForm.state = data.help.state
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/cat/help/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userid': this.dataForm.userid,
                'adminsid': this.dataForm.adminsid,
                'petid': this.dataForm.petid,
                'commenttime': this.dataForm.commenttime,
                'content': this.dataForm.content,
                'state': this.dataForm.state
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
