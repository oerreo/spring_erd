package likelionjpa.jpashop.domain;

//쿠팡 API에서 가져옴
public enum DeliveryStatus {
    ACCEPT,	//결제완료
    INSTRUCT,	//상품준비중
    DEPARTURE,	//배송지시
    DELIVERING,	//배송중
    FINAL_DELIVERY,	//배송완료
    NONE_TRACKING  //업체 직접 배송(배송 연동 미적용), 추적불가

}
