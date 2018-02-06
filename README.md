# ジャズ和声を含む楽曲の組み合わせ範疇文法に基づく解析システムの実装

## 概要
調性音楽の最も基本的な要素の一つである和声を機械的に解析することで、自動採譜や自動作編曲、楽曲類似度推定による楽曲レコメンドへの応用をねらいとしています。

現在流通している商業音楽に大きな影響を与えているジャズを対象に、自然言語処理の手法の一つである組み合わせ範疇文法(CCG)と和音間の距離を定量的に求めるTonal Pitch Spaceをそれぞれ改良させながらジャズ和声の解析に用いております。

従来の手法に比べて解析できる曲の対象が増えたが、短調から長調への転調で精度が落ちる傾向があるため、引き続きCCGとTPSの改良を行うだけでなく、機械学習などによる手法の導入により精度の向上が期待されます。

[スライドはこちら](https://www.slideshare.net/TakeshiFukunari/ss-87299947)

## 発表論文
[福成毅, 東条敏, "非古典的和声を含む楽曲のCCGによる解析" 人工知能学会全国大会, 2016年6月](https://kaigi.org/jsai/webprogram/2016/paper-1123.html)

[Takeshi Fukunari, Sean Arn, Satoshi Tojo "CCG analyzer with Tonal Pitch Space for non-classical chords" Knowledge and Systems Engineering (KSE), 2016 Eighth International Conference on](http://ieeexplore.ieee.org/document/7758060/)

