<template>
    <div class="common-layout">
        <el-container>
            <el-affix :offset="120" style="margin-left: 365px;">
                <el-card v-if="displayCard2" style="max-width: 480px">
                    <h2>修改就业信息</h2>
                    <el-form :model="form" ref="form" label-position="right">
                        <el-form-item label="学号" prop="sno">
                            <el-input v-model="employment.sno"></el-input>
                        </el-form-item>
                        <el-form-item label="公司名称" prop="enterprise">
                            <el-input v-model="employment.enterprise"></el-input>
                        </el-form-item>
                        <el-form-item label="姓名" prop="sname">
                            <el-input v-model="employment.sname"></el-input>
                        </el-form-item>
                        <el-form-item label="专业" prop="major">
                            <el-input v-model="employment.major"></el-input>
                        </el-form-item>
                        <el-form-item label="电话" prop="tele">
                            <el-input v-model="employment.tele"></el-input>
                        </el-form-item>
                        <el-form-item label="详细信息" prop="info">
                            <el-input v-model="employment.info"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="updateEmployment()">修改</el-button>
                            <el-button type="warning" @click="cancelUpdate()">返回</el-button>
                        </el-form-item>
                    </el-form>
                </el-card>
            </el-affix>
            <el-affix :offset="120" style="margin-left: 365px;">
                <el-card v-if="displayCard1" style="max-width: 480px">
                    <h2>添加就业</h2>
                    <el-form :model="form" ref="form" label-position="right">
                        <el-form-item label="学号" prop="sno">
                            <el-input v-model="employment.sno"></el-input>
                        </el-form-item>
                        <el-form-item label="公司名称" prop="enterprise">
                            <el-input v-model="employment.enterprise"></el-input>
                        </el-form-item>
                        <el-form-item label="姓名" prop="sname">
                            <el-input v-model="employment.sname"></el-input>
                        </el-form-item>
                        <el-form-item label="专业" prop="major">
                            <el-input v-model="employment.major"></el-input>
                        </el-form-item>
                        <el-form-item label="电话" prop="tele">
                            <el-input v-model="employment.tele"></el-input>
                        </el-form-item>
                        <el-form-item label="详细信息" prop="info">
                            <el-input v-model="employment.info"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="addEmployment()">添加</el-button>
                            <el-button type="warning" @click="cancelEmployment()">返回</el-button>
                        </el-form-item>
                    </el-form>
                </el-card>
            </el-affix>
            <el-header class="search">
                <div class="mt-4">
                    <el-button @click="startEmployment()" style="max-width: 400px;margin-top:15px;margin-left:967px"
                        type="primary">增加就业</el-button>
                </div>
            </el-header>
            <el-main>

                <el-table :data="form" stripe style="width: 100%">
                    <el-table-column prop="sno" label="学号" width="120" />
                    <el-table-column prop="enterprise" label="公司名称" width="180" />
                    <el-table-column prop="sname" label="姓名" width="120" />
                    <el-table-column prop="major" label="专业" width="120" />
                    <el-table-column prop="tele" label="电话" width="150" />
                    <el-table-column prop="info" label="详细信息" />
                    <el-table-column label="操作">
                        <template #default="scope">
                            <el-button type="warning" @click="startUpdateEmployment(scope.row, scope.$index)">
                                修改
                            </el-button>
                            <el-button type="danger" @click="deleteEmployment(scope.row, scope.$index)">
                                删除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </el-main>
        </el-container>
    </div>
</template>

<script>
import { findAllEmployment, deleteEmployment, addEmployment, updateEmployment } from '@/api/employment';
export default {
    data() {
        return {
            i: "",
            displayCard1: 0,
            displayCard2: 0,
            form: [],
            employment: {
                sno: "",
                enterprise: "",
                sname: "",
                major: "",
                tele: "",
                info: ""
            }
        }
    },
    async mounted() {
        this.form = (await findAllEmployment()).data;
    },
    methods: {
        async findMineEmployment() {
            const temp = {
                sno: sessionStorage.getItem("userid")
            }
            this.form = (await findEmploymentBySno(temp)).data
        },
        async addEmployment() {

            await addEmployment(this.employment)
            this.displayCard1 = 0;
            this.form.push({ ...this.employment })
        },
        cancelEmployment() {
            this.displayCard1 = 0;
            console.log("取消添加就业");
        },
        startEmployment() {
            this.employment={}
            this.displayCard1 = 1
        },
        async deleteEmployment(row, index) {
            await deleteEmployment(row)
            this.form.splice(index, 1)
        },
        cancelUpdate() {
            this.displayCard2 = 0;
        },
        startUpdateEmployment(s, i) {
            this.displayCard2 = 1;
            this.employment.sno = s.sno;
            this.employment.enterprise = s.enterprise;
            this.employment.sname = s.sname;
            this.employment.major = s.major;
            this.employment.tele = s.tele;
            this.employment.info = s.info;
            this.i = i;
        },
        async updateEmployment() {
            await updateEmployment(this.employment)
            this.form[this.i] = { ...this.employment };
            this.displayCard2 = 0;
        }
    }
}
</script>