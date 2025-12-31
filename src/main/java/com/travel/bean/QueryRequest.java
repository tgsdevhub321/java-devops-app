package com.travel.bean;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "agentId",
    "qsource",
    "qtype",
    "pnr",
    "airline",
    "paxName",
    "queryDate",
    "noPax",
    "sellingPrice",
    "buyingCost",
    "contactNo",
    "emailId",
    "dateOfTravel",
    "queryRat",
    "siteId",
	"supplier",
	"queryStatus",
	"outboundFromairport",
	"outboundToairport",
	"outboundFlightNo",
	"outboundClass",
	"outboundAirline",
	"inboundFromairport",
	"inboundToairport",
	"inboundFlightNo",
	"inboundClass",
	"inboundAirline",
	"adult",
	"child",
	"infant",
	"infantws",
	"mco",
	"returnDate"
})

public class QueryRequest {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("agentId")
    private Integer agentId;
    @JsonProperty("qsource")
    private String qsource;
    @JsonProperty("qtype")
    private String qtype;
    @JsonProperty("pnr")
    private String pnr;
    @JsonProperty("airline")
    private String airline;
    @JsonProperty("paxName")
    private String paxName;
    @JsonProperty("queryDate")
    private String queryDate;
    @JsonProperty("noPax")
    private Integer noPax;
    @JsonProperty("sellingPrice")
    private Double sellingPrice;
    @JsonProperty("buyingCost")
    private Double buyingCost;
    @JsonProperty("contactNo")
    private String contactNo;
    @JsonProperty("emailId")
    private String emailId;
    @JsonProperty("dateOfTravel")
    private String dateOfTravel;
    @JsonProperty("queryRat")
    private Integer queryRat;
    @JsonProperty("siteId")
    private Integer siteId;
	@JsonProperty("supplier")
	private String supplier;
	@JsonProperty("queryStatus")
	private String queryStatus;
	
	@JsonProperty("outboundFromairport")
	private String outboundFromairport; 
	@JsonProperty("outboundToairport")
	private String outboundToairport; 
	@JsonProperty("outboundFlightNo")
	private String outboundFlightNo;
	@JsonProperty("outboundClass")
	private String outboundClass;
	@JsonProperty("outboundAirline")
	private String outboundAirline;
	@JsonProperty("inboundFromairport")
	private String inboundFromairport;
	@JsonProperty("inboundToairport")
	private String inboundToairport; 
	@JsonProperty("inboundFlightNo")
	private String inboundFlightNo;
	@JsonProperty("inboundClass")
	private String inboundClass;
	@JsonProperty("inboundAirline")
	private String inboundAirline;
	@JsonProperty("adult")
	private Integer adult;
	@JsonProperty("child")
	private Integer child;
	@JsonProperty("infant")
	private Integer infant;
	@JsonProperty("infantws")
	private Integer infantws;
	@JsonProperty("mco")
	private Double mco;
	@JsonProperty("returnDate")
	private String returnDate;
	
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("agentId")
    public Integer getAgentId() {
        return agentId;
    }

    @JsonProperty("agentId")
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    @JsonProperty("qsource")
    public String getQsource() {
        return qsource;
    }

    @JsonProperty("qsource")
    public void setQsource(String qsource) {
        this.qsource = qsource;
    }

    @JsonProperty("qtype")
    public String getQtype() {
        return qtype;
    }

    @JsonProperty("qtype")
    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    @JsonProperty("pnr")
    public String getPnr() {
        return pnr;
    }

    @JsonProperty("pnr")
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    @JsonProperty("airline")
    public String getAirline() {
        return airline;
    }

    @JsonProperty("airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @JsonProperty("paxName")
    public String getPaxName() {
        return paxName;
    }

    @JsonProperty("paxName")
    public void setPaxName(String paxName) {
        this.paxName = paxName;
    }

    @JsonProperty("queryDate")
    public String getQueryDate() {
        return queryDate;
    }

    @JsonProperty("queryDate")
    public void setQueryDate(String queryDate) {
        this.queryDate = queryDate;
    }

    @JsonProperty("noPax")
    public Integer getNoPax() {
        return noPax;
    }

    @JsonProperty("noPax")
    public void setNoPax(Integer noPax) {
        this.noPax = noPax;
    }

    @JsonProperty("sellingPrice")
    public Double getSellingPrice() {
        return sellingPrice;
    }

    @JsonProperty("sellingPrice")
    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @JsonProperty("buyingCost")
    public Double getBuyingCost() {
        return buyingCost;
    }

    @JsonProperty("buyingCost")
    public void setBuyingCost(Double buyingCost) {
        this.buyingCost = buyingCost;
    }

    @JsonProperty("contactNo")
    public String getContactNo() {
        return contactNo;
    }

    @JsonProperty("contactNo")
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @JsonProperty("emailId")
    public String getEmailId() {
        return emailId;
    }

    @JsonProperty("emailId")
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @JsonProperty("dateOfTravel")
    public String getDateOfTravel() {
        return dateOfTravel;
    }

    @JsonProperty("dateOfTravel")
    public void setDateOfTravel(String dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    @JsonProperty("queryRat")
    public Integer getQueryRat() {
        return queryRat;
    }

    @JsonProperty("queryRat")
    public void setQueryRat(Integer queryRat) {
        this.queryRat = queryRat;
    }

    @JsonProperty("siteId")
	public Integer getSiteId() {
		return siteId;
	}
	
	@JsonProperty("siteId")
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	@JsonProperty("supplier")
	public String getSupplier() {
		return supplier;
	}
	
	@JsonProperty("supplier")
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	@JsonProperty("queryStatus")
	public String getQueryStatus() {
		return queryStatus;
	}
	
	@JsonProperty("queryStatus")
	public void setQueryStatus(String queryStatus) {
		this.queryStatus = queryStatus;
	}
	
	@JsonProperty("outboundFromairport")
    public String getOutboundFromairport() {
		return outboundFromairport;
	}

    @JsonProperty("outboundFromairport")
	public void setOutboundFromairport(String outboundFromairport) {
		this.outboundFromairport = outboundFromairport;
	}

    @JsonProperty("outboundToairport")
	public String getOutboundToairport() {
		return outboundToairport;
	}

    @JsonProperty("outboundToairport")
	public void setOutboundToairport(String outboundToairport) {
		this.outboundToairport = outboundToairport;
	}

    @JsonProperty("outboundFlightNo")
	public String getOutboundFlightNo() {
		return outboundFlightNo;
	}

    @JsonProperty("outboundFlightNo")
	public void setOutboundFlightNo(String outboundFlightNo) {
		this.outboundFlightNo = outboundFlightNo;
	}

    @JsonProperty("outboundClass")
	public String getOutboundClass() {
		return outboundClass;
	}

    @JsonProperty("outboundClass")
	public void setOutboundClass(String outboundClass) {
		this.outboundClass = outboundClass;
	}

    @JsonProperty("outboundAirline")
	public String getOutboundAirline() {
		return outboundAirline;
	}

    @JsonProperty("outboundAirline")
	public void setOutboundAirline(String outboundAirline) {
		this.outboundAirline = outboundAirline;
	}

    @JsonProperty("inboundFromairport")
	public String getInboundFromairport() {
		return inboundFromairport;
	}

    @JsonProperty("inboundFromairport")
	public void setInboundFromairport(String inboundFromairport) {
		this.inboundFromairport = inboundFromairport;
	}

    @JsonProperty("inboundToairport")
	public String getInboundToairport() {
		return inboundToairport;
	}
    
    @JsonProperty("inboundToairport")
	public void setInboundToairport(String inboundToairport) {
		this.inboundToairport = inboundToairport;
	}

    @JsonProperty("inboundFlightNo")
	public String getInboundFlightNo() {
		return inboundFlightNo;
	}

    @JsonProperty("inboundFlightNo")
	public void setInboundFlightNo(String inboundFlightNo) {
		this.inboundFlightNo = inboundFlightNo;
	}

    @JsonProperty("inboundClass")
	public String getInboundClass() {
		return inboundClass;
	}

    @JsonProperty("inboundClass")
	public void setInboundClass(String inboundClass) {
		this.inboundClass = inboundClass;
	}

    @JsonProperty("inboundAirline")
	public String getInboundAirline() {
		return inboundAirline;
	}

    @JsonProperty("inboundAirline")
	public void setInboundAirline(String inboundAirline) {
		this.inboundAirline = inboundAirline;
	}

    @JsonProperty("adult")
	public Integer getAdult() {
		return adult;
	}

    @JsonProperty("adult")
	public void setAdult(Integer adult) {
		this.adult = adult;
	}

    @JsonProperty("child")
	public Integer getChild() {
		return child;
	}

    @JsonProperty("child")
	public void setChild(Integer child) {
		this.child = child;
	}

    @JsonProperty("infant")
	public Integer getInfant() {
		return infant;
	}

    @JsonProperty("infant")
	public void setInfant(Integer infant) {
		this.infant = infant;
	}

    @JsonProperty("infantws")
	public Integer getInfantws() {
		return infantws;
	}

    @JsonProperty("infantws")
	public void setInfantws(Integer infantws) {
		this.infantws = infantws;
	}

    @JsonProperty("mco")
	public Double getMco() {
		return mco;
	}

    @JsonProperty("mco")
	public void setMco(Double mco) {
		this.mco = mco;
	}
    
    @JsonProperty("returnDate")
	public String getReturnDate() {
		return returnDate;
	}
    
    @JsonProperty("returnDate")
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
    
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
