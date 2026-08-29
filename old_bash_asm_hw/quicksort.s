.data                      
array:  .word  10,81,72,63,55,12,44,67,96,21  

.text                      
.global _start

_start:
        push    {r4, r5, r6, lr}    
        ldr     r0, =array           
        mov     r1, #0              
        mov     r2, #9              
        bl      quick_sort          
        pop     {r4, r5, r6, pc}    

swap_elements: 
        ldr     r2, [r1]            
        ldr     r3, [r0]            
        str     r2, [r0]            
        str     r3, [r1]            
        bx      lr                  

partition_array:
        push    {r4, r5, r9, lr}   
        ldr     r12, [r0, r2, lsl #2] 
        mov     r9, r1              
        cmp     r2, r1              
        ble     partition_done      
        add     r3, r0, r9, lsl #2  
        sub     r1, r2, r9          
        sub     r9, r9, #1          
        b       partition_loop

partition_inner_loop:
        add     r3, r3, #4          
        subs    r1, r1, #1          
        beq     partition_end      

partition_loop:
        ldr     r4, [r3]            
        cmp     r4, r12             
        bge     partition_inner_loop 
        add     r9, r9, #1          
        ldr     r5, [r0, r9, lsl #2] 
        str     r4, [r0, r9, lsl #2] 
        str     r5, [r3]            
        b       partition_inner_loop

partition_end:
        ldr     r12, [r0, r2, lsl #2] 
        add     r9, r9, #1          

partition_done:
        ldr     r1, [r0, r9, lsl #2] 
        str     r12, [r0, r9, lsl #2] 
        str     r1, [r0, r2, lsl #2]  
        mov     r0, r9              
        pop     {r4, r5, r9, pc}   

quick_sort:
        cmp     r1, r2              
        bxge    lr                  
        push    {r4, r5, r6, r7, r8, r9, lr} 
        mov     r4, r2              
        mov     r5, r0              
        add     r8, r0, #4          
        b       quicksort_loop

quicksort_swap:
        ldr     r0, [r5, r4, lsl #2] 
        ldr     r2, [r8, r6, lsl #2] 
        str     r0, [r8, r6, lsl #2] 
        str     r2, [r5, r4, lsl #2]
        mov     r0, r5              
        mov     r2, r6              
        bl      quick_sort          
        add     r1, r6, #2          
        cmp     r1, r4              
        bge     quicksort_done

quicksort_loop:
        ldr     r0, [r5, r4, lsl #2] 
        sub     r6, r1, #1          
        mov     r2, r1              
        b       quicksort_inner_loop

quicksort_partition:
        add     r2, r2, #1          
        cmp     r4, r2              
        beq     quicksort_swap      

quicksort_inner_loop:
        ldr     r3, [r5, r2, lsl #2] 
        cmp     r3, r0              
        bge     quicksort_partition 
        add     r6, r6, #1          
        ldr     r7, [r5, r6, lsl #2] 
        str     r3, [r5, r6, lsl #2] 
        str     r7, [r5, r2, lsl #2]
        b       quicksort_partition

quicksort_done:
        pop     {r4, r5, r6, r7, r8, r9, lr} 
        bx      lr
