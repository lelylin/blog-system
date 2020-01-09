$(document).ready(function() {
    var boxHtml = '<div class="box">\n' +
        '        <div class="wxbox">\n' +
        '            <ul>\n' +
        '                <li><img src="/static/images/wxgzh.jpg"><span>微信公众号</span></li>\n' +
        '                <li><img src="/static/images/wx.png"><span>我的微信</span></li>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '        <div class="endnav">\n' +
        '            <p><b>站点声明：</b></p>\n' +
        '            <p>1、本站的图片和文章部分来自网络，如有侵权，请使用本站联系方式告知，博主将会在第一时间做出处理。</p>\n' +
        '            <p>2、欢迎各位朋友分享本站内容到个人网站或者朋友圈，但转载请说明文章来源。</p>\n' +
        '            <p>Copyright © <a href="http://www.dannylin.cn" target="_blank">www.dannylin.cn</a>\n' +
        '                All Rights Reserved. 备案号：\n' +
        '                <a href="http://www.miitbeian.gov.cn/" target="_blank">蜀ICP备11002373号-1</a>\n' +
        '            </p>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <a href="#">\n' +
        '        <div class="top"></div>\n' +
        '    </a>';
    $("#foot").html(boxHtml);
})