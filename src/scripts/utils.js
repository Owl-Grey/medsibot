
/**
 * Проверка любого объекта на пустоту
 *
 * @param   {unknown}     obj Объект для проверки
 * @returns {obj is null}     True (пустой) / false (не пустой)
 */
function isEmpty(obj) {
    if (!obj) {
        return true;
    }
    if (Array.isArray(obj) && obj.length === 0) {
        return true;
    }
    if (typeof obj === 'object' && obj !== null && Object.keys(obj).length === 0) {
        return true;
    }
    // условия ниже вряд ли будут выполнены (они уже входят в !obj), но для наглядности пусть останутся
    if (obj === null) {
        return true;
    }
    if (typeof obj === 'undefined') {
        return true;
    }
    if (obj === '') {
        return true;
    }
    if (obj === false) {
        return true;
    }
    return false;
}



/**
 * # FuncYou
 *
 * Функция, которая заменяет Ты на Вы
 *
 * CHANGED: определение глобального client ВНУТРИ функции
 *
 * @param   {string} text4Vy - Вариант текста для Вы
 * @param   {string} text4vy - Вариант текста для вы
 * @param   {string} text4ty - Вариант текста для ты
 * @returns {string}         Строка, которая учитывает наши пожелания
 */
function funcYou(text4Vy, text4vy, text4ty) {
    var fnName = 'funcYou';
    var client = $jsapi.context().client;
    var args = [text4Vy, text4vy, text4ty];
    var argsAreBad = args.some(function (argum) {
        return (typeof argum !== 'string' && typeof argum !== 'number') || isEmpty(argum);
    });
    if (argsAreBad) {
        return '';
    }

    return client.you === 'Вы' ? text4Vy : client.you === 'вы' ? text4vy : text4ty;
}



    
