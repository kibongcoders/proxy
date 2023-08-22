<h1>프록시 데코레이터 패턴</h1>
<h2>클라이언트 - 서버</h2>
<img height="200px" src="https://mobiinsidecontent.s3.ap-northeast-2.amazonaws.com/kr/wp-content/uploads/2022/03/21131312/%ED%97%A4%EB%82%981.png"/>
<p><b>클라이언트는 서버에 필요한 것을 요청하고, 서버는 클라이언트의 요청을 처리</b>하는 것이다.<br/>
클라이언트가 직접 요청하는 경우도 있겠지만 간접요청하는 경우도 있는데
</p>
<img height="200px" src="https://velog.velcdn.com/images%2Fsyoung125%2Fpost%2F047f5d9d-b735-4c5f-8d19-06603bb37814%2Fimage.png"/>
<p>우리는 이거를 <b>프록시(대리자)</b>가 간접요청 가능합니다.</p>
<p>프록시패턴과 데코레이터 패턴에 대해서 알아보려고 합니다.
둘이 패턴의 모양은 굉장히 유사합니다. 사실 모양은 차이가 없다고 봐도 무방합니다.
</p>
<img src="https://www.mscharhag.com/files/2020/proxy-pattern.jpg" height="200">