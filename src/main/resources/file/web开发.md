# web开发
使用spring boot  
1.创建spring boot应用，选中我们需要的场景；  
2.spring boot就会默认将这些场景配置好了，我们只需要在配置文件中指定少量配置就可以运行起来；  
3.自己编写业务代码。  
**自动配置原理？**  
这个场景spring boot帮我们配置了什么？能不能修改？能修改那些配置？能不能扩展？......  
[^xxxxAutoConfiguration]:帮我们给容器中自动配置组件；  
[^xxxxProperties]:配置类来封装配置文件的内容