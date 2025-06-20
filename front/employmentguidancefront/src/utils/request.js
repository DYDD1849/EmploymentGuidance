import axios from 'axios'

// 创建axios实例
const service = axios.create({
  baseURL: 'http://localhost:8081/api',
  timeout: 5000
  // 不要加 headers: { 'Content-Type': ... }
})

// 请求拦截器（如需token可在此统一添加）
service.interceptors.request.use(config => {
  // 可在此添加全局逻辑（如token）
  return config
})

// 响应拦截器（统一处理错误）
service.interceptors.response.use(
  response => response.data, // 直接返回data字段
  error => {
    console.error('请求错误:', error)
    return Promise.reject(error)
  }
)

export default service