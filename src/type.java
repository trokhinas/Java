enum type {
    kupe(1),
    plac(2);

    int value;
    type(int i) {
        value = i;
    }
    int getValue() {
        return value;
    }
}
