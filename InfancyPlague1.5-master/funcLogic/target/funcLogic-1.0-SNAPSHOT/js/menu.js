
/**
 * JSON无限折叠菜单
 * @constructor {AccordionMenu}
 * @param {options} 对象
 * @date 2013-12-13
 * @author tugenhua
 * @email 879083421@qq.com
 */

function AccordionMenu(options) {
    this.config = {
        containerCls        : '.wrap-menu',                // 外层容器
        menuArrs            :  '',                         //  JSON传进来的数据
        type                :  'click',                    // 默认为click 也可以mouseover
        renderCallBack      :  null,                       // 渲染html结构后回调
        clickItemCallBack   : null                         // 每点击某一项时候回调
    };
    this.cache = {

    };
    this.init(options);
}


AccordionMenu.prototype = {
    constructor: AccordionMenu,
    //constructor: "${ctx}/sys/menu/getMenuJson",
    init: function(options){
        this.config = $.extend(this.config,options || {});
        var self = this,
            _config = self.config,
            _cache = self.cache;

        // 渲染html结构
        $(_config.containerCls).each(function(index,item){

            self._renderHTML(item);

            // 处理点击事件
            self._bindEnv(item);
        });
    },
    _renderHTML: function(container){
        var self = this,
            _config = self.config,
            _cache = self.cache;
        var ulhtml = $('<ul></ul>');
        $(_config.menuArrs).each(function(index,item){
            var lihtml = $("<li><h4><i class=\'"+item.icon+"\'></i>"+item.name+"</h4></li>");

            if(item.submenu && item.submenu.length > 0) {
                $(lihtml).children('h4').append('<span class="fa fa-angle-right"></span>');
                self._createSubMenu(item.submenu,lihtml);
            }
            $(ulhtml).append(lihtml);
        });
        $(container).append(ulhtml);

        _config.renderCallBack && $.isFunction(_config.renderCallBack) && _config.renderCallBack();

        // 处理层级缩进
        self._levelIndent(ulhtml);
    },
    /**
     * 创建子菜单
     * @param {array} 子菜单
     * @param {lihtml} li项
     */
    _createSubMenu: function(submenu,lihtml){
        var self = this,
            _config = self.config,
            _cache = self.cache;
        var subUl = $('<ul></ul>'),
            callee = arguments.callee,
            subLi;

        $(submenu).each(function(index,item){
            var url = item.url || null;
            if(url == null){
                subLi = $('<li><a href="javascript:;" target="mainFrame" >'+item.name+'</a></li>');
            }else{
                subLi = $('<li><a href="'+ctx+url+'" target="mainFrame" >'+item.name+'</a></li>');
            }

            if(item.submenu && item.submenu.length > 0) {
                $(subLi).children('a').prepend('<img src="'+ctxStatic+'/images/blank.gif" alt=""/>');
                callee(item.submenu, subLi);
            }
            $(subUl).append(subLi);
        });
        $(lihtml).append(subUl);
    },
    /**
     * 处理层级缩进
     */

    /*_levelIndent: function(ulList){
     var self = this,
     _config = self.config,
     _cache = self.cache,
     callee = arguments.callee;

     var initTextIndent = 2,
     lev = 1,
     $oUl = $(ulList);

     while($oUl.find('ul').length > 0){
     initTextIndent = parseInt(initTextIndent,10) + 2 + 'em';
     $oUl.children().children('ul').addClass('lev-' + lev)

     //              $oUl.children().children('ul').css('text-indent', initTextIndent)

     .children('li').css('text-indent', initTextIndent);
     //            	  .children('li').addClass('lev-' + lev);
     $oUl = $oUl.children().children('ul');
     lev++;
     }
     $(ulList).find('ul').hide();
     $(ulList).find('ul:first').show();
     },*/

    _levelIndent: function(ulList){
        var self = this,
            _config = self.config,
            _cache = self.cache,
            callee = arguments.callee;

        var initTextIndent = 2,
            lev = 1,
            $oUl = $(ulList);

        while($oUl.find('ul').length > 0){
            initTextIndent = parseInt(initTextIndent,10) + 1 + 'em';
            $oUl.children().children('ul').addClass('lev-' + lev)
                .children('li').css('text-indent', initTextIndent);
            $oUl = $oUl.children().children('ul');
            lev++;
        }
        $(ulList).find('ul').hide();
        $(ulList).find('ul:first').show();
    },

    /**
     * 绑定事件
     */
    _bindEnv: function(container) {
        var self = this,
            _config = self.config;
        //初始化一级菜单 li的图标

        $('.wrap-menu li:eq(0)').find('span').attr('class','fa fa-angle-down');
        $('h4,a',container).unbind(_config.type);


        $("h4").each(function(){
            $('h4').click(function(){
                $('h4').css("background","");
                $(this).css("background","rgb(19, 30, 38)");
            })
        })

        $('a').each(function(index, el) {
            $('a').click(function(){
                $('a').removeClass("active");
                $(this).addClass("active");
            })
        });


        $('h4,a',container).bind(_config.type,function(e){
            if($(this).siblings('ul').length > 0) {

                $(this).siblings('ul').slideToggle('slow').end().children('img').toggleClass('unfold');

                //一级标题的图标变化

                if($(this).children('span').hasClass("fa fa-angle-right")){

                    //$(this).children('span').attr('class','fa fa-angle-down');
                    $(this).children('span').removeClass().addClass('fa fa-angle-down');
                }else{

                    //$(this).children('span').attr('class','fa fa-angle-right');
                    $(this).children('span').removeClass().addClass('fa fa-angle-right');
                }

            }

            //子菜单的点击效果
            /* $("a").each(function (i) {
             $(this).click(function () {
             $(this).css('background',"rgb(19, 30, 38)");
             $(this).partents().siblings().find('a').css('background','none');

             });



             });*/



            //判断点击一级菜单，当前图标的变化

            $(this).parent('li').siblings().find('ul').hide().end().find('span').removeClass().addClass('fa fa-angle-right')
            $(this).parent('li').siblings().find('ul').hide().end().find('img.unfold').removeClass('unfold');


            _config.clickItemCallBack && $.isFunction(_config.clickItemCallBack) && _config.clickItemCallBack($(this));

        });
    }


    /*//点击子菜单时添加.active
     $('.wrap-menu ul li a').on('click',function(){
     if($(this).partent().partent().siblings().find('img').hasClass('.unfold')){
     console.log($(this));
     $(this).addClass('.active').siblings().removeClass('.active');
     }else{
     $(this).siblings().removeClass('.active');
     }
     })*/



};