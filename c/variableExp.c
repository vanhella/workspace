#include <stdio.h>

int main(){
        float fahr, celsius;
        float lower, upper, step;

        lower = 0;
        upper = 300;
        step = 20;

        fahr = lower;
        while (fahr <= upper) {
                celsius = 5*(fahr-32)/9;
                printf("%6.2f\t%6.2f\n", fahr,celsius);
                fahr = fahr+step;
        }
        return 0;
}
