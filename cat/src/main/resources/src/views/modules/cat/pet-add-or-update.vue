<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="petname">
      <el-input v-model="dataForm.petname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="宠物类型" prop="pettype">
      <el-input v-model="dataForm.pettype" placeholder="宠物类型"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="pic">
      <el-input v-model="dataForm.pic" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="现在的状态 0 没有申请领养 1 被申请领养 2 已经被领养" prop="state">
      <el-input v-model="dataForm.state" placeholder="现在的状态 0 没有申请领养 1 被申请领养 2 已经被领养"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
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
          petname: '',
          pettype: '',
          sex: '',
          birthday: '',
          pic: '',
          state: '',
          remark: ''
        },
        dataRule: {
          petname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pettype: [
            { required: true, message: '宠物类型不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pic: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '现在的状态 0 没有申请领养 1 被申请领养 2 已经被领养不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/cat/pet/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.petname = data.pet.petname
                this.dataForm.pettype = data.pet.pettype
                this.dataForm.sex = data.pet.sex
                this.dataForm.birthday = data.pet.birthday
                this.dataForm.pic = data.pet.pic
                this.dataForm.state = data.pet.state
                this.dataForm.remark = data.pet.remark
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
              url: this.$http.adornUrl(`/cat/pet/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'petname': this.dataForm.petname,
                'pettype': this.dataForm.pettype,
                'sex': this.dataForm.sex,
                'birthday': this.dataForm.birthday,
                'pic': this.dataForm.pic,
                'state': this.dataForm.state,
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
