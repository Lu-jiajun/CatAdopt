<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户表id的外键" prop="userid">
      <el-input v-model="dataForm.userid" placeholder="用户表id的外键"></el-input>
    </el-form-item>
    <el-form-item label="宠物表id的外键" prop="petid">
      <el-input v-model="dataForm.petid" placeholder="宠物表id的外键"></el-input>
    </el-form-item>
    <el-form-item label="" prop="adopttime">
      <el-input v-model="dataForm.adopttime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="是否同意被领养 0 是不同意 1 还在审核 2 是同意" prop="state">
      <el-input v-model="dataForm.state" placeholder="是否同意被领养 0 是不同意 1 还在审核 2 是同意"></el-input>
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
          petid: '',
          adopttime: '',
          state: ''
        },
        dataRule: {
          userid: [
            { required: true, message: '用户表id的外键不能为空', trigger: 'blur' }
          ],
          petid: [
            { required: true, message: '宠物表id的外键不能为空', trigger: 'blur' }
          ],
          adopttime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '是否同意被领养 0 是不同意 1 还在审核 2 是同意不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/cat/adoptanimal/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userid = data.adoptanimal.userid
                this.dataForm.petid = data.adoptanimal.petid
                this.dataForm.adopttime = data.adoptanimal.adopttime
                this.dataForm.state = data.adoptanimal.state
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
              url: this.$http.adornUrl(`/cat/adoptanimal/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userid': this.dataForm.userid,
                'petid': this.dataForm.petid,
                'adopttime': this.dataForm.adopttime,
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
