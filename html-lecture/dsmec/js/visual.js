//json

Splitting();
const swiper = new Swiper(".main-visual", {
  effect: "slide",
  loop: true,
  autoplay: {
    delay: 3000,
    disableOnInteraction: false,
  },
  speed: 1000,
  pagination: {
    el: ".main-visual .pagination",
    type: "bullets",
    clickable: true,
  },
  navigation: {
    prevEl: ".main-visual .btn-prev",
    nextEl: ".main-visual .btn-next",
  },
  on: {
    slideChangeTransitionEnd: function () {
      console.log(this.realIndex);
      //console.log("swiper slideChangeTransitionEnd");
      gsap.to(".swiper-slide-active .char", { y: 0, opacity: 1, stagger: 0.05 });
    },
    slideChangeTransitionStart: function () {
      console.log(this.realIndex);
      //console.log("swiper slideChangeTransitionEnd");
      gsap.set(".swiper-slide-active .char", { y: 100, opacity: 0 });
    },
    init: function () {
      gsap.from(".swiper-slide-active .char", { y: 100, opacity: 0, stagger: 0.05 });
    },
  },
});

//~때  했을때  이벤트(사건, 사고)

//gsap.from(".visual02 .char", { y: -100, opacity: 0, stagger: 0.05 });
