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