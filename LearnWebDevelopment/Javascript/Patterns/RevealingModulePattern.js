// Return Object literals that directly give access to stuff inside the module
const ItemCtrl = (function() {
    let data = [];

    function add(item) {
        data.push(item);
        console.log('Item Added');
    }

    function get(id) {
        return data.find(item => {
            return item.id === id;
        });
    }

    // Bind private functions and make them public
    return {
        add: add,
        get
    }
})();

ItemCtrl.add({id:1, name:'John'});