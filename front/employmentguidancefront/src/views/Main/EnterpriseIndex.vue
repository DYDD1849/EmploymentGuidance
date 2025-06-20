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
          <el-button @click="startRecruit()" style="max-width: 400px;margin-top:15px;margin-left:200px"
            type="primary">增加招聘</el-button>
          <el-button @click="findMineRecruit()" style="max-width: 400px;margin-top:15px;margin-left:20px"
            type="primary">我的招聘</el-button>
        </div>
      </el-header>
      <el-main>

        <el-affix :offset="120" style="margin-left: 365px;">
          <el-card v-if="displayCard1" style="max-width: 480px">
            <h2>修改招聘</h2>
            <el-form :model="form" ref="form" label-position="right">
              <el-form-item label="岗位" prop="position">
                <el-input v-model="recruit.position"></el-input>
              </el-form-item>
              <el-form-item label="薪资/元" prop="salary">
                <el-input v-model="recruit.salary"></el-input>
              </el-form-item>
              <el-form-item label="详细信息" prop="info">
                <el-input v-model="recruit.info"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="updateRecruit()">修改</el-button>
                <el-button type="warning" @click="cancelUpdate()">返回</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </el-affix>

        <el-affix :offset="120" style="margin-left: 365px;">
          <el-card v-if="displayCard2" style="max-width: 480px">
            <h2>增加招聘</h2>
            <el-form :model="form" ref="form" label-position="right">
              <el-form-item label="岗位" prop="position">
                <el-input v-model="recruit.position"></el-input>
              </el-form-item>
              <el-form-item label="薪资/元" prop="salary">
                <el-input v-model="recruit.salary"></el-input>
              </el-form-item>
              <el-form-item label="详细信息" prop="info">
                <el-input v-model="recruit.info"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="addRecruit()">增加</el-button>
                <el-button type="warning" @click="cancelRecruit()">返回</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </el-affix>

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
              <el-button v-if="scope.row.eno === userid" type="warning"
                @click="startUpdateRecruit(scope.row, scope.$index)">
                修改
              </el-button>
              <el-button v-if="scope.row.eno === userid" type="danger" @click="deleteRecruit(scope.row, scope.$index)">
                删除
              </el-button>

              <el-button v-if="scope.row.eno === userid" type="success" @click="viewResumes(scope.row)">
                查看简历
              </el-button>
            </template>

          </el-table-column>
        </el-table>
      </el-main>
    </el-container>
  </div>
  <el-dialog title="简历列表" v-model="resumeDialogVisible" width="30%">
    <el-card v-for="file in resumeList" :key="file.fname" style="margin-bottom: 10px;">
      <div>
        <span>{{ file.fname }}</span>
        <el-button type="primary" size="mini" style="float:right" @click="handleDownload(file.fname)">下载</el-button>
      </div>
    </el-card>
    <span slot="footer" class="dialog-footer">
      <el-button @click="resumeDialogVisible = false">关闭</el-button>
    </span>
  </el-dialog>
</template>

<script>
import { findAllRecruit, deleteRecruit, updateRecruit, findRecruitByEnterprise, addRecruit, findRecruitByPosition } from '@/api/recruit';
import { elPaginationKey } from 'element-plus';
import { findFileByRid, downloadFile } from '@/api/file';

export default {


  data() {
    return {
      displayCard1: 0,
      displayCard2: 0,
      form: [

      ],
      userid: "",
      input: {
        position: ""
      },
      recruit: {
        position: "",
        salary: "",
        info: "",
        ename: sessionStorage.getItem("name"),
        eno: sessionStorage.getItem("userid")
      },
      resumeDialogVisible: false,
      resumeList: [], // 存放简历文件名
      currentRecruitId: null
    }
  },
  async mounted() {

    this.form = (await findAllRecruit()).data;
    this.userid = sessionStorage.getItem("userid");
  },
  methods: {
    async findMineRecruit() {
      const temp = {
        eno: sessionStorage.getItem("userid")
      }
      this.form = (await findRecruitByEnterprise(temp)).data

    },
    startUpdateRecruit(s, i) {
      this.displayCard1 = 1;
      this.recruit = { ...s }
      this.i = i;
    },
    cancelUpdate() {
      this.displayCard1 = 0;
    },
    async updateRecruit() {
      try {
        console.log("更新招聘信息", this.recruit);
        await updateRecruit(this.recruit);
        this.displayCard1 = 0;
        this.form.splice(this.i, 1, { ...this.recruit });
      } catch (error) {
        alert("更新失败");
      }
    },

    async deleteRecruit(s, i) {
      await deleteRecruit(s);
      this.form.splice(i, 1);
    },
    async search() {
      console.log("搜索", this.input)
      this.form = (await findRecruitByPosition(this.input)).data;
    },
    async addRecruit() {

      await addRecruit(this.recruit)
      this.displayCard2 = 0;
      this.form.push(this.recruit)
    },
    cancelRecruit() {
      this.displayCard2 = 0;
    },
    startRecruit() {
            this.recruit.position=""
      this.recruit.salary = ""
      this.recruit.info = ""  
      this.displayCard2 = 1;
    },


    // ...existing code...
    async viewResumes(recruit) {
      const res = await findFileByRid({ rid: recruit.rid });
      console.log("简历列表", res.data.fname);
      this.resumeList = res.data;
      console.log("简历列表", this.resumeList);
      this.resumeDialogVisible = true;
    },
    async handleDownload(fileName) {
      try {
        const res = await downloadFile(fileName);
        // 创建下载链接
        const url = window.URL.createObjectURL(new Blob([res]));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', fileName);
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
        window.URL.revokeObjectURL(url);
      } catch (e) {
        this.$message.error('下载失败');
      }
    },
    // ...existing code...
    toMessage(a) {
      const enterpriseinfo = a
      console.log(JSON.stringify(enterpriseinfo))
      this.$router.push({
        name: 'Message',
        query: {
          enterpriseinfo: JSON.stringify(enterpriseinfo)
        }
      })
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