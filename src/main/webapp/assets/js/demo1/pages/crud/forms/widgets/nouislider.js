// Class definition
var KTnoUiSliderDemos = function() {

    // Private functions

     
  

    var demo2 = function() {
        // init slider
        var slider = document.getElementById('kt_nouislider_2');

        noUiSlider.create(slider, {
            start: [ 0 ],
            connect: [true, false],
            step: 50000,
            range: {
                'min': [ 0 ],
                'max': [ 5000000 ]
            },
            format: wNumb({
                thousand: '',
                postfix: '(CLP $)',
            })
        });

        // init slider input
        var sliderInput = document.getElementById('kt_nouislider_2_input');

        slider.noUiSlider.on('update', function( values, handle ) {
            sliderInput.value = values[handle];
        });

        sliderInput.addEventListener('change', function(){
            slider.noUiSlider.set(this.value);
        });
    }

 
    return {
        // public functions
        init: function() {
            demo2();                         
        }
    };
}();

jQuery(document).ready(function() {
    KTnoUiSliderDemos.init();
});


