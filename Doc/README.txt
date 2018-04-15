

実行すると下記の流れで動作します。
１、Jobを実行
2、Listenerを実行
３、Step１を実行
３−１、Readerでアイテムを読み込む
３−２、Processorで読み込んだ物を加工
３−３、Writerで加工したデータを書き込む
４、Step２を実行（内容は3と同様）
５、Listenerを実行
