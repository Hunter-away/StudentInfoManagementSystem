// var sign_in_btn = document.querySelector("#sign-in-btn");
// var sign_up_btn = document.querySelector("#sign-up-btn");
// var container = document.querySelector(".container");

// sign_up_btn.addEventListener('click',()=>{
//     container.classList.add("sign-up-mode");
// })

// sign_up_btn.addEventListener('click',()=>{
//     container.classList.remove("sign-up-mode");
// })

// JQuery version to improve the function
$(function(){
    $("#sign-up-btn").click(function(){
        $(".container").toggleClass("sign-up-mode");
    });

    $("#sign-in-btn").click(function(){
        $(".container").toggleClass("sign-up-mode");
    });

    $(".btn-stu").click(function(){
        $(".stu-form").show();
        $(".teh-form").hide();
      
    });

    $(".btn-teh").click(function(){
        $(".stu-form").hide();
        $(".teh-form").show();
        // $(".stu-form").animate({left:"1000px"});
    });


// form-search animate
    $("#form-search").click(function(){
        $("#input-search").animate({left:'510px', opacity: .9});
        $("#form-subtn").animate({left:'766px', opacity: .9});
    });

    // $("#sinput").click(function(){
    //     // var _html = '';
    //     // _html = '<input class="score-input" type="text">';
    //     // $("#sinput").html(_html);
    //     $(".sinput-text").css("display","none");
    //     $(".score-input").css("display","block");
    // });

});