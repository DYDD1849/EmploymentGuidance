<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2 style="text-align:center;">毕业生就业指导信息平台</h2>
      <el-form :model="form" ref="form" label-position="top">
        <el-form-item label="企业号/学号" prop="userid" :rules="[{ required: true, message: '请输入用户名', trigger: 'blur' }]">
          <el-input v-model="form.userid"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password" :rules="[{ required: true, message: '请输入密码', trigger: 'blur' }]">
          <el-input type="password" v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleLogin">登录</el-button>
          <el-button @click="$router.push('/Register')">注册</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { login } from "@/api/login"

export default {

  data() {
    return {
      form: {
        userid: 'dydd',
        password: 'dydd'
      }
    }
  },
  methods: {
    async handleLogin() {
      console.log('登录', this.form);
      const user = await login(this.form);
      if (user.data != null) {
        sessionStorage.setItem("userid", this.form.userid);
        sessionStorage.setItem("state", user.data.state);
        if (user.data.state == 1) {
          sessionStorage.setItem("name", user.data.sname)
          this.$router.push('/StudentIndex');
        } else if (user.data.state == 2) {
          sessionStorage.setItem("name", user.data.ename)
          console.log(user.data.ename);
          this.$router.push('/EnterpriseIndex');
        } else if (user.data.state == 3) {
          this.$router.push('/ManageIndex');
        }
      } else {
        alert("账号或密码错误，登录失败！");
      }

    }
  }
}
</script>

<style scoped>
.login-container {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #3c90d0;
}

.login-card {
  width: 500px;
  padding: 20px;
  height: 400px;
}
</style>