### 指针

#### 指针的应用场景

- 函数返回多个值，某些值就只能通过指针返回。如**交换 2 个变量的值**。
- 传入的参数实际上是个变量，这个变量能够把结果带回来。如**计算出数组中的最小和最大值**。
- 函数返回运算的状态，结果通过指针返回。如 **2个整数相除，既要知道是否成功，也要知道相除的结果**。

**交换2个变量的值：**

```c
//交换2个变量的值 
int swap(int *a,int *b){
	int a_value = *a;
	*a = *b;
	*b = a_value; 
}
```

**计算出数组中的最小和最大值：**

```c
int min_max(int *min,int *max,int array[],int len){
	if(len == 1){
		return 0;
	}
	int i;
	for(i = 0;i < len;i++){
		if(*max < array[i]){
			*max = array[i];
		}
		if(*min > array[i]){
			*min = array[i];
		}
	}
	return 0;
}
```

#### 常量指针

```c
int a = 0;
int* const p = &a;
*p = 9; //ok
p++; //error
```

这个指针指向的地址不能改变了，但是它指向的地址上的变量值可以改变。

#### 所指是 const

```c
int a = 0;
const int *p = &a;
*p = 1; //error 
a = 1; //ok
p = &j; //ok
```

a 和 p 都可改变，但不能通过指针 p 去改变 a。

#### 保护数组的值

把数组传入函数时，不想让函数修改数组，可以把参数设置为 const

```c
int sum(const int arr[],int length){}
```

#### 指针的运算

- 不同类型的指针变量不要相互赋值。
- 可以这么运算：+, +=, -, -=, --, ++.
- 两个指针相减。实际上就是 2 个指针的地址单元[sizeof(指针类型)]的差值。
- *P++
  - 取出 p 所指的那个数，完了后顺便把 p 移到下一个位置。
  - ++ 优先级高于 *
  - 常用于数组的连续空间操作
  - 在某些 CPU 上，这可以直接被翻译成一条汇编指令。

---

#### 0 地址

- 内存中有 0 地址，但该地址不能随便使用。
- 所以指针不应该具有 0 值。
- 可以用 0 地址表示特殊的事情：
  - 返回的指针是无效的。
  - 指针没有被真正初始化。
- NULL 是一个预定义的符号，表示 0 地址
  - 有的编译器不愿意你用 0 来表示 0 地址。

---

### 动态内存分配

##### 输入数据

- 如果输入数据时，先告诉你个数，然后在输入，要记录每个数据

- C99 可以用变量做数组定义的大小，C99 之前呢？

  ```c
  int *a = (int*)malloc(n*sizeof(int));
  ```

- malloc 函数

  - ```c
    #include <stdlib.h>
    void* malloc(size_t size);
    ```

  - 向 malloc 申请的空间大小是以字节为单位的。

  - 返回的结果是 void*，需要类型转换为自己需要的类型

  - ```c
    //比如
    (int*)malloc(n*sizeof(int));
    ```

  - 用完之后，要释放调内存： free(指针变量)

  - 如果申请失败则返回 0，或者 NULL
  
- free()

  - 把申请来的空间还给“系统”.
  - 申请过的空间，最终都应该要还。
  - 只能还申请来的空间的首地址。