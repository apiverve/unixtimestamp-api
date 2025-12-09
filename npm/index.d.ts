declare module '@apiverve/unixtimestamp' {
  export interface unixtimestampOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface unixtimestampResponse {
    status: string;
    error: string | null;
    data: UnixTimestampConverterData;
    code?: number;
  }


  interface UnixTimestampConverterData {
      timestamp:        number;
      timestampFormat:  string;
      iso8601:          Date;
      rfc2822:          string;
      date:             string;
      time:             string;
      unixSeconds:      number;
      unixMilliseconds: number;
      year:             number;
      month:            number;
      day:              number;
      hour:             number;
      minute:           number;
      second:           number;
      dayOfWeek:        string;
      timezone:         string;
  }

  export default class unixtimestampWrapper {
    constructor(options: unixtimestampOptions);

    execute(callback: (error: any, data: unixtimestampResponse | null) => void): Promise<unixtimestampResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: unixtimestampResponse | null) => void): Promise<unixtimestampResponse>;
    execute(query?: Record<string, any>): Promise<unixtimestampResponse>;
  }
}
