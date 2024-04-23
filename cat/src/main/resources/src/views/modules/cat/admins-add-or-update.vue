<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="adminname">
      <el-input v-model="dataForm.adminname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="adminpwd">
      <el-input v-model="dataForm.adminpwd" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="realname">
      <el-input v-model="dataForm.realname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="telephone">
      <el-input v-model="dataForm.telephone" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="email">
      <el-input v-model="dataForm.email" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sex">
      <el-input v-model="dataForm.sex" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pic">
      <el-input v-model="dataForm.pic" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="remark">
      <el-input v-model="dataForm.remark" placeholder=""></el-input>
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
          adminname: '',
          adminpwd: '',
          realname: '',
          telephone: '',
          email: '',
          birthday: '',
          sex: '',
          pic: '',
          remark: ''
        },
        dataRule: {
          adminname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          adminpwd: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          realname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          telephone: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pic: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          remark: [
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
              url: this.$http.adornUrl(`/cat/admins/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.adminname = data.admins.adminname
                this.dataForm.adminpwd = data.admins.adminpwd
                this.dataForm.realname = data.admins.realname
                this.dataForm.telephone = data.admins.telephone
                this.dataForm.email = data.admins.email
                this.dataForm.birthday = data.admins.birthday
                this.dataForm.sex = data.admins.sex
                this.dataForm.pic = data.admins.pic
                this.dataForm.remark = data.admins.remark
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
              url: this.$http.adornUrl(`/cat/admins/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'adminname': this.dataForm.adminname,
                'adminpwd': this.dataForm.adminpwd,
                'realname': this.dataForm.realname,
                'telephone': this.dataForm.telephone,
                'email': this.dataForm.email,
                'birthday': this.dataForm.birthday,
                'sex': this.dataForm.sex,
                'pic': this.dataForm.pic,
                'remark': this.dataForm.remark
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
