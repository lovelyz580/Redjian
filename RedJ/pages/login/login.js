const app = getApp();
Page({
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  onLoad: function() {
    var that = this;
    // 查看是否授权
    wx.getSetting({
      success: function(res) {
        if (res.authSetting['scope.userInfo']) {
          wx.getUserInfo({
            success: function(res) {
              //用户已经授权过
              console.log("您已授权");

            }
          });
        }
      }
    })
  },
  bindGetUserInfo: function(e) {
    var that = this;
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      wx.login({
        success: function(r) {
          var code = r.code;
          //登录凭证  console.log(code)
          if (code) {
            //2、调用获取用户信息接口
            wx.getUserInfo({
              withCredentials: true,
              success: function(res) {
                // 获取用户的头像信息
                // console.log({ encryptedData: res.encryptedData, iv: res.iv, code: code })
                //3.请求自己的服务器，解密用户信息 获取unionId等加密信息
                // 获取用户信息
                app.util.request({
                  url: 'wechat/login',
                  header: {
                    'content-type': 'application/x-www-form-urlencoded'
                  },
                  method: "POST",
                  data: {
                    encryptedData: res.encryptedData,
                    iv: res.iv,
                    code: code
                  },
                  success: function(data) {
                    //4.解密成功后 获取自己服务器返回的结果
                    if (data.data.code == 200) {
                      app.globalData.avatarUrl = data.data.data.avatarUrl;
                      app.globalData.nickName = data.data.data.nickName;
                      app.globalData.openId = data.data.data.openId;
                      app.globalData.country = data.data.data.country;
                      app.globalData.city = data.data.data.city;
                      app.globalData.province = data.data.data.province
                      that.writedata();
                    } else {
                      console.log('解密失败')
                    }

                  },
                  fail: function() {
                    console.log('系统错误')
                  }
                })
              }
            })
          }

        }
      })
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
        showCancel: false,
        confirmText: '返回授权',
        success: function(res) {
          if (res.confirm) {
            console.log('用户点击了“返回授权”')
          }
        }
      })
    }
  },
  //写入数据库
  writedata:function (){
    var that = this;
    var  data = app.globalData;

    console.log(data);
    app.util.request({
      url: 'user/insterByUser',
      header: {
        "Content-Type": "application/json;charset=UTF-8"
      },
      method: "POST",
      data: {
        data: JSON.stringify(data)
      },
      success: function (data) {
        console.log(data)
        
      }
    })
  }

})