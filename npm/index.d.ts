declare module '@apiverve/unixtimestamp' {
  export interface unixtimestampOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface unixtimestampResponse {
    status: string;
    error: string | null;
    data: UnixTimestampConverterData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface UnixTimestampConverterData {
      timestamp:        number | null;
      timestampFormat:  null | string;
      iso8601:          Date | null;
      rfc2822:          null | string;
      date:             null | string;
      time:             null | string;
      unixSeconds:      number | null;
      unixMilliseconds: number | null;
      year:             number | null;
      month:            number | null;
      day:              number | null;
      hour:             number | null;
      minute:           number | null;
      second:           number | null;
      dayOfWeek:        null | string;
      timezone:         null | string;
  }

  export default class unixtimestampWrapper {
    constructor(options: unixtimestampOptions);

    execute(callback: (error: any, data: unixtimestampResponse | null) => void): Promise<unixtimestampResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: unixtimestampResponse | null) => void): Promise<unixtimestampResponse>;
    execute(query?: Record<string, any>): Promise<unixtimestampResponse>;
  }
}
