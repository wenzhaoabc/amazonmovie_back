# Hive

## 条件组合查询电影

- 接口 ：`/hive/movie/result`
- POST
- Body：

```json
{
  "movieName": "",
  "minYear": "",
  "minMonth": "",
  "minDay": "",
  "maxYear": "",
  "maxMonth": "",
  "maxDay": "",
  "category": "",
  "directorNames": [
    ""
  ],
  "mainActors": [
    ""
  ],
  "actors": [
    ""
  ],
  "minScore": 1.0,
  "maxScore": 5.0,
  "positive": 1
}
```

- 返回数据类型

```json
{
  "movies": [
    {
      "asin": "",
      "title": "",
      "edition": "",
      "score": 3.4,
      "commentNum": 23,
      "year": 23,
      "month": 23,
      "day": 23
    },
    50个
  ],
  "movieNum": 45,
  "time": ""
}
```

## 查询和某位导演合作次数最多的前10位演员

- `/hive/director/actor`
- GET
- param directorName
- 返回数据类型

```json
{
  "actors": [
    {
      "name": "",
      "num": 12
    }
  ],
  "time": 23 (查询时间：毫秒),
  "length": 5 (actor长度)
}
```

## 查询和某位演员合作次数最多的导演
- `/hive/actor/director`
- GET
- param actorName
- 返回数据类型
```json
{
  "director": [
    {
      "name": "",
      "num": 12
    }
  ],
  "time": 23 (查询时间：毫秒),
  "length": 5 (director长度)
}
```

## 查询和某位演员合作次数最多的演员
- `/hive/actor/actor`
- GET
- param actorName
- 返回数据类型
```json
{
  "actor": [
    {
      "name": "",
      "num": 12
    }
  ],
  "time": 23 (查询时间：毫秒),
  "length": 5 (actor长度)
}
```