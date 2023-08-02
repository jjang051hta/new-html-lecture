//json

const swiper = new Swiper(".main-visual", {
  effect: "slide",
  loop: true,
  autoplay: {
    delay: 3000,
  },
  speed: 1000,
  pagination: {
    el: ".main-visual .pagination",
    type: "bullets",
  },
});
