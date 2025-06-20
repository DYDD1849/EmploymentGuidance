<template>
    <el-menu class="el-menu-demo" mode="horizontal" :ellipsis="false">
        <el-menu-item @click="$router.push('/ManageIndex/student')" index="1">毕业生信息管理</el-menu-item>
        <el-menu-item @click="$router.push('/ManageIndex/employment')" index="2">毕业生就业情况管理</el-menu-item>
        <el-menu-item @click="$router.push('/ManageIndex/recruit')" index="3">招聘信息管理</el-menu-item>
        <el-menu-item @click="$router.push('/')" index="4"> 回到登录</el-menu-item>
    
    </el-menu>
    <router-view />
</template>
