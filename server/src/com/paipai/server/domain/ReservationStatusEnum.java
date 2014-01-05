package com.paipai.server.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum ReservationStatusEnum {

	Inline,
	Dining,
	Closed,
	Pending,
	Quit,
	Invalid
}
