<template>

  <div class="common-layout">
    <el-container>
      <el-header class="search">
        <div class="mt-4">
          <el-input v-model="input.position" style="max-width: 400px;margin-top:15px;margin-left:400px"
            placeholder="搜索岗位" class="input-with-select">
            <template #append>
              <el-button @click="search()">搜索</el-button>
            </template>
          </el-input>
        </div>
      </el-header>
      <el-main>
        <el-table :data="form" stripe style="width: 100%">
          <el-table-column prop="position" label="岗位" width="180" />
          <el-table-column prop="salary" label="薪水/元" width="180" />
          <el-table-column prop="ename" label="用人单位" width="180" />
          <el-table-column prop="info" label="详细信息" />
          <!-- 操作列：使用作用域插槽 -->
          <el-table-column label="操作">
            <template #default="scope">
              <el-button type="primary" @click="toMessage(scope.row)">
                留言
              </el-button>
              <el-button type="success" @click="openResumeDialog(scope.row)">
                投递简历
              </el-button>
            </template>

          </el-table-column>

        </el-table>
      </el-main>

    </el-container>
    <el-dialog title="投递简历" v-model="resumeDialogVisible" width="30%">
      <el-upload class="upload-demo" drag :http-request="customUploadHandler" :before-upload="beforeUpload"
        :show-file-list="false">
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip" slot="tip">只能上传PDF/Word文件，且不超过5MB</div>
      </el-upload>
      <span slot="footer" class="dialog-footer">
        <el-button @click="resumeDialogVisible = false">取 消</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { findAllRecruit, findRecruitByPosition } from '@/api/recruit';
import { uploadResume, findFileByRid } from '@/api/file'

export default {


  data() {
    return {
      form: [

      ],
      input: {
        position: ""
      },
      resumeDialogVisible: false,
      uploadExtraData: {
        rid: "",
      },
      file: [
        {
          fileName: ""
        }
      ],
      currentRecruit: null
    }
  },
  async mounted() {

    this.form = (await findAllRecruit()).data;
  },
  methods: {
    async search() {
      console.log("搜索", this.input)
      this.form = (await findRecruitByPosition(this.input)).data;
    },
    async findFileByRid(rid) {
      const response = await findFileByRid(rid);
      this.file = response.data;
      console.log("文件信息", this.file);
    },
    toMessage(a) {
      const enterpriseinfo = a
      console.log(JSON.stringify(enterpriseinfo))
      this.$router.push({
        name: 'Message',
        query: {
          enterpriseinfo: JSON.stringify(enterpriseinfo)
        }
      })
    },
    openResumeDialog(recruit) {
      this.currentRecruit = recruit;
      this.resumeDialogVisible = true;
      this.uploadExtraData.rid = recruit.rid; // 假设招聘信息中有一个 rid 字段
    },
    async customUploadHandler(param) {
      try {
        await uploadResume(param.file, this.uploadExtraData);
        this.$message.success('简历上传成功');
        this.resumeDialogVisible = false;
      } catch (e) {
        this.$message.error('上传失败');
      }
    },
    beforeUpload(file) {
      const isAllowed = file.type === 'application/pdf' ||
        file.type === 'application/msword' ||
        file.type === 'application/vnd.openxmlformats-officedocument.wordprocessingml.document';
      const isLt5M = file.size / 1024 / 1024 < 5;
      if (!isAllowed) {
        this.$message.error('只能上传PDF或Word文件');
      }
      if (!isLt5M) {
        this.$message.error('文件大小不能超过5MB');
      }
      return isAllowed && isLt5M;
    }
    
  }
}
</script>

<style scoped>
.el-descriptions {
  margin-top: 20px;
}

.cell-item {
  display: flex;
  align-items: center;
}

.margin-main {
  margin-top: 0px;
}

.margin-aside {
  padding: 20px;
}

.search {
  background-color: antiquewhite;
}
</style>