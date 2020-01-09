$(document).ready(function() {
    var rboxHtml ='<div class="whitebg paihang">\n' +
        '            <h2 class="htitle">点击排行</h2>\n' +
        '            <section class="topnews imgscale">\n' +
        '                <a href="/">\n' +
        '                    <img th:src="@{/static/images/h1.jpg}">\n' +
        '                    <span>6条网页设计配色原则,让你秒变配色高手</span>\n' +
        '                </a>\n' +
        '            </section>\n' +
        '            <ul>\n' +
        '                <li><i></i><a href="/">十条设计原则教你学会如何设计网页布局!</a></li>\n' +
        '                <li><i></i><a href="/">用js+css3来写一个手机栏目导航</a></li>\n' +
        '                <li><i></i><a href="/">6条网页设计配色原则,让你秒变配色高手</a></li>\n' +
        '                <li><i></i><a href="/">三步实现滚动条触动css动画效果</a></li>\n' +
        '                <li><i></i><a href="/">个人博客，属于我的小世界！</a></li>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '        <div class="whitebg tuijian">\n' +
        '            <h2 class="htitle">本栏推荐</h2>\n' +
        '            <section class="topnews imgscale">\n' +
        '                <a href="/"><img src="/static/images/h2.jpg">\n' +
        '                    <span>6条网页设计配色原则,让你秒变配色高手</span>\n' +
        '                </a>\n' +
        '            </section>\n' +
        '            <ul>\n' +
        '                <li>\n' +
        '                    <a href="/">\n' +
        '                        <i><img src="/static/images/text01.jpg"></i>\n' +
        '                        <p>十条设计原则教你学会如何设计网页布局!</p>\n' +
        '                    </a>\n' +
        '                </li>\n' +
        '                <li>\n' +
        '                    <a href="/">\n' +
        '                        <i><img src="/static/images/text02.jpg"></i>\n' +
        '                        <p>用js+css3来写一个手机栏目导航</p>\n' +
        '                    </a>\n' +
        '                </li>\n' +
        '                <li>\n' +
        '                    <a href="/">\n' +
        '                        <i><img src="/static/images/text03.jpg"></i>\n' +
        '                        <p>6条网页设计配色原则,让你秒变配色高手</p>\n' +
        '                    </a>\n' +
        '                </li>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '        <div class="ad whitebg imgscale">\n' +
        '            <ul>\n' +
        '                <a href="/"><img src="/static/images/ad.jpg"></a>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '        <div class="whitebg cloud">\n' +
        '            <h2 class="htitle">标签云</h2>\n' +
        '            <ul>\n' +
        '                <a href="" target="_blank">个人博客模板</a>\n' +
        '                <a href="" target="_blank">css动画</a>\n' +
        '                <a href="" target="_blank">布局</a>\n' +
        '                <a href="" target="_blank">今夕何夕</a>\n' +
        '                <a href="" target="_blank">SEO</a>\n' +
        '                <a href="" target="_blank">女程序员</a>\n' +
        '                <a href="" target="_blank">小世界</a>\n' +
        '                <a href="" target="_blank">个人博客</a>\n' +
        '                <a href="" target="_blank">网页设计</a>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '        <div class="whitebg wenzi">\n' +
        '            <h2 class="htitle">猜你喜欢</h2>\n' +
        '            <ul>\n' +
        '                <li><a href="/">十条设计原则教你学会如何设计网页布局!</a></li>\n' +
        '                <li><a href="/">用js+css3来写一个手机栏目导航</a></li>\n' +
        '                <li><a href="/">6条网页设计配色原则,让你秒变配色高手</a></li>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '        <div class="ad whitebg imgscale">\n' +
        '            <ul>\n' +
        '                <a href="/"><img src="/static/images/ad02.jpg"></a>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '        <div class="whitebg tongji">\n' +
        '            <h2 class="htitle">站点信息</h2>\n' +
        '            <ul>\n' +
        '                <li><b>建站时间</b>：2018-10-24</li>\n' +
        '                <li><b>文章统计</b>：299条</li>\n' +
        '                <li><b>文章评论</b>：490条</li>\n' +
        '                <li><b>统计数据</b>：<a href="/">百度统计</a></li>\n' +
        '                <li><b>微信公众号</b>：扫描二维码，关注我们</li>\n' +
        '                <img src="/static/images/wxgzh.jpg" class="tongji_gzh">\n' +
        '            </ul>\n' +
        '        </div>';
    $(".rbox").html(rboxHtml);
})