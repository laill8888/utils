--
-- Created by IntelliJ IDEA.
-- User: laili
-- Date: 2018/12/22
-- Time: 10:26
-- To change this template use File | Settings | File Templates.
--
--单行注释
--[[
多行注释
]]
local x = 10
print(x)
print("--------------")

print(3 ^ 2)
print(2 / 3)
print(4 % 3)
local a, b = math.modf(2 / 3);
print(a)
print(3 ~= 3)
print(x)

print('--------------------')
print(not true)
print(true and true)
print(false or true)
print(0 and 3)
print(1 or 4)

print('---------------------')
local a=0
for   i=1,9,1 do
    a=a+i
end
print(a)
print('------------------')
local c={}
c['name']='lisi'
print(c.name)