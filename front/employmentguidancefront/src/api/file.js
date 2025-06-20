import request from '@/utils/request'

// 上传简历文件（表单方式，file为文件对象，data为额外参数）
export const uploadResume = (file, data = {}) => {
  const formData = new FormData()
  formData.append('file', file)
  formData.append('rfile', JSON.stringify(data))
  return request.post('/upload', formData)
}

// 下载文件
export const downloadFile = fileName => {
  return request.post(`/download/${fileName}`, {
    responseType: 'blob'
  })
}

export const findFileByRid = data => request.post('/findFile', data)