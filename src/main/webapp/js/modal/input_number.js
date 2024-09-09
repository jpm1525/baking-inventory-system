document.querySelectorAll(".num-input").forEach(function(inputElement) {
    inputElement.addEventListener("keypress", function (e) {
        var allowedChars = '0123456789.';
        
        function contains(stringValue, charValue) {
            return stringValue.indexOf(charValue) > -1;
        }
        
        var invalidKey = e.key.length === 1 && !contains(allowedChars, e.key)
            || e.key === '.' && contains(e.target.value, '.');
        
        if (invalidKey) {
            e.preventDefault();
        }
    });
});
