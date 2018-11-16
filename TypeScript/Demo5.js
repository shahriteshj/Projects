function calculate_discount(price, rate) {
    if (rate === void 0) { rate = 0.5; }
    console.log(price * rate);
}
calculate_discount(1000);
calculate_discount(1000, 0.3);
