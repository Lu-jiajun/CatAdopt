<template>
  <el-dialog
    :title="!dataForm.petname ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="宠物类型" prop="pettype">
      <el-input v-model="dataForm.pettype" placeholder="宠物类型"></el-input>
    </el-form-item>
    <el-form-item label="" prop="2023-extract(year from birthday )">
      <el-input v-model="dataForm.2023-extract(year from birthday )" placeholder=""></el-input>
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
          petname: 0,
          pettype: '',
          2023-extract(year from birthday ): ''
        },
        dataRule: {
          pettype: [
            { required: true, message: '宠物类型不能为空', trigger: 'blur' }
          ],
          2023-extract(year from birthday ): [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.petname = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.petname) {
            this.$http({
              url: this.$http.adornUrl(`/cat/petsex/info/${this.dataForm.petname}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.pettype = data.petsex.pettype
                this.dataForm.2023-extract(year from birthday ) = data.petsex.2023-extract(year from birthday )
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
              url: this.$http.adornUrl(`/cat/petsex/${!this.dataForm.petname ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'petname': this.dataForm.petname || undefined,
                'pettype': this.dataForm.pettype,
                '2023-extract(year from birthday )': this.dataForm.2023-extract(year from birthday )
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
