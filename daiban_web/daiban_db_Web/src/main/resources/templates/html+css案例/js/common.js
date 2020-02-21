/**
 * 注册点击事件，除了根据id注册点击事件以外，其它都返回数组
 * @param element 按钮属性
 * @returns {}
 */
function my$(element) {
    if (element != null){
        var className = document.getElementsByClassName(element);
        //根据class属性名
        if (className.length != 0){
            return className;
        }
        //1、根据id属性名    2、根据标签名     3、根据name属性名
        return document.getElementById(element) ||
            document.getElementsByTagName(element)||
            document.getElementsByName(element);
    }
    return "请传入值";
}

/**
 * 节点兼容代码
 */
{
//获取任意一个父级元素的第一个子元素
    function getFirstElementChild(element) {
        if (element.firstElementChild) {//true --->>支持
            return element.firstElementChild;
        } else {
            var node = element.firstChild;//第一个节点
            while (node && node.nodeType != 1) {
                node = node.nextSibling;
            }
            return node;
        }
    }

//获取任意一个父级元素的最后一个子元素
    function getLastElementChild(element) {
        if (element.lastElementChild) {//true --->>支持
            return element.lastElementChild;
        } else {
            var node = element.lastChild;//第一个节点
            while (node && node.nodeType != 1) {
                node = node.previousSibling;
            }
            return node;
        }
    }
}

/**
 * 绑定事件&解绑事件兼容代码
 */
{
    //绑定事件
    function addEventListener(element, type, fn) {
        if (element.addEventListener) {
            element.addEventListener(type, fn, false);
        } else if (element.attachEvent) {
            element.attachEvent("on" + type, fn);
        } else {
            element["on" + type] = fn;
        }
    }

    //解绑事件
    function removeEventListener(element, type, fnName) {
        if (element.removeEventListener) {
            element.removeEventListener(type, fnName, false);
        } else if (element.datachEvent) {
            element.datachEvent("on" + type, fnName);
        } else {
            element["on" + type] = null;
        }
    }
}