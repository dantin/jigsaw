/opt/mongodb/bin/mongod

# 切换DB
use tutorial
# 插入数据
db.users.insert({username: "smith"})
db.users.save({username: "jones"})

# 批量增加一批数据
for(i=0; i<200000;i++) {
    db.numbers.save({num: i});
}

# 统计数据
db.users.find()
db.users.count()

# 查询
db.users.find({username: "jones"})
db.users.find({"favorites.movies": "Casablanca"})
it  # 游标
db.numbers.find({num: 500})
db.numbers.find({num: {"$gt": 199995}})
db.numbers.find({num: {"$gt": 20, "$lt": 25}})

# 更新
db.users.update({username: "smith"}, {$set: {country: "Canada"}})
db.users.update({username: "smith"}, {$unset: {country:1}})
db.users.update({username: "smith"},
{$set: {favorites:
  {
    cities: ["Chicago", "Cheyenne"],
    movies: ["Casablanca", "The Sting"]
  }
}
})
db.users.update({username: "jones"},
{$set: {favorites:
  {
    movies: ["Casablanca", "Rocky"]
  }
}
})
# 默认只匹配第一个文档，这里是批量更新
db.users.update({"favorites.movies": "Casablanca"},
{$addToSet: {"favorites.movies": "The Maltese Falcon"}},
false,
true)

# 删除
# 清空集合，类似TRUNCATE TABLE
db.foo.remove()
# 删除某一行数据
db.users.remove({"favorites.cities": "Cheyenne"})
# 删除集合
db.users.drop()