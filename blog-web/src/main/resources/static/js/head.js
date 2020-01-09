console.log("88888");
$(document).ready(function() {
    console.log("99999");
    var headerHTML = '<div class="navbox">\n' +
        '        <h2 id="mnavh"><span class="navicon"></span></h2>\n' +
        '        <div class="logo"><a href="">Danny博客</a></div>\n' +
        '        <nav>\n' +
        '            <ul id="starlist">\n' +
        '                <li><a href="/">网站首页</a></li>\n' +
        '                <li><a href="/lifeLearning">学无止境</a></li>\n' +
        '                <li><a href="/brokenWords">碎言碎语</a></li>\n' +
        '                <li><a href="/websiteBuilding">网站建设</a></li>\n' +
        '                <li><a href="/timeTunnel">时空隧道</a></li>\n' +
        '                <li><a href="/aboutMe">关于我</a></li>\n' +
        '            </ul>\n' +
        '        </nav>\n' +
        '        <div class="searchico"></div>\n' +
        '    </div>';
    $("#header").html(headerHTML);
    console.log(00000000000000);
    console.log(headerHTML);

    var searchboxHtml = '<div class="search">\n' +
        '        <form action="/e/search/index.php" method="post" name="searchform" id="searchform">\n' +
        '            <input name="keyboard" id="keyboard" class="input_text" value="请输入关键字词"\n' +
        '                   style="color: rgb(153, 153, 153);" onfocus="if(value==\'请输入关键字词\'){this.style.color=\'#000\';value=\'\'}"\n' +
        '                   onblur="if(value==\'\'){this.style.color=\'#999\';value=\'请输入关键字词\'}" type="text">\n' +
        '            <input name="show" value="title" type="hidden">\n' +
        '            <input name="tempid" value="1" type="hidden">\n' +
        '            <input name="tbname" value="news" type="hidden">\n' +
        '            <input name="Submit" class="input_submit" value="搜索" type="submit">\n' +
        '        </form>\n' +
        '    </div>\n' +
        '    <div class="searchclose"></div>';
    $(".searchbox").html(searchboxHtml);

})