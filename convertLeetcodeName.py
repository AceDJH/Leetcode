#!/usr/bin/python3
str = input("请输入题目名,当前为Easy：")
# eg : str = '235. Lowest Common Ancestor of a Binary Search Tree'
str1 = str.replace('. ', '_')
str2 = str1.replace(' ', '_')
# 更改名字中的难度时，修改degree
degree = 'E_'
print(degree + str2)
